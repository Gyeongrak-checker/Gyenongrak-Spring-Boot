package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Package;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeService {

    private final AtCodeRequest codeRequest;

    private final AgriculturalCategoryRepository agriculturalCategoryRepository;
    private final GradeRepository gradeRepository;
    private final PlaceOriginsRepository placeOriginsRepository;
    private final PackageRepository packageRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductVarietyRepository productVarietyRepository;
    private final WholesaleCoporationRepository wholesaleCoporationRepository;
    private final WholesaleMarketRepository wholesaleMarketRepository;


    @Value("${code.totalCount.corps}")
    private int corpsTotalCount;

    @Value("${code.totalCount.grades}")
    private int gradeTotalCount;

    @Value("${code.totalCount.units}")
    private int unitTotalCount;

    @Value("${code.totalCount.placeOrigins}")
    private int placeOriginsCount;

    @Value("${code.totalCount.packagings}")
    private int packageTotalCount;

    @Value("${code.totalCount.goods}")
    private int productItemTotalCount;

    @Value("${code.totalCount.wholesaleMarkets}")
    private int wholesaleMarketTotalCount;

    public void init() {
        productItemRepository.deleteAll();
        productVarietyRepository.deleteAll();
        agriculturalCategoryRepository.deleteAll();
        wholesaleCoporationRepository.deleteAll();
        wholesaleMarketRepository.deleteAll();
        packageRepository.deleteAll();
        placeOriginsRepository.deleteAll();
        gradeRepository.deleteAll();


        setGrade();

        setPackage();

        setWholesaleMarket();

        setPlaceOrigins();

        setProductCodes();

    }

    private void setGrade() {
        List<Grade> gradeCodes = codeRequest.getGrades(0, gradeTotalCount).getItems().stream().map(GradeCode::toEntity).toList();
        gradeRepository.saveAll(gradeCodes);
    }

    private void setPackage() {
        List<Package> packages = codeRequest.getPackages(0, packageTotalCount).getItems().stream().map(PackagingCode::toEntity).toList();
        packageRepository.saveAll(packages);
    }

    private void setPlaceOrigins() {
        List<PlaceOrigins> placeOrigins = codeRequest.getPlaceOrigins(0, placeOriginsCount).getItems().stream().map(PlaceOriginsCode::toEntity).toList();
        placeOriginsRepository.saveAll(placeOrigins);
    }

    private void setWholesaleMarket() {
        List<WholesaleMarket> wholesaleMarkets = codeRequest.getMarket(0, wholesaleMarketTotalCount).getItems().stream().map(WholesaleMarketsCode::toEntity).toList();
        wholesaleMarketRepository.saveAll(wholesaleMarkets);
    }

    private void setWholesaleCoporation() {

    }



    private void setProductCodes() {
        List<ProductCode> codes = codeRequest.getProduct(0, productItemTotalCount).getItems();

        List<AgriculturalCategory> categories = new ArrayList<>();
        List<ProductVariety> varieties = new ArrayList<>();
        List<ProductItem> items = new ArrayList<>();

        ProductVariety currentVariety;

        for (ProductCode code : codes) {

            // 소분류 (항상 ProductItem 추가)
            ProductItem item = ProductItem.builder()
                    .code(code.getSmall())
                    .name(code.getSmallName())
                    .build();
            items.add(item);

            // 중분류 구분 조건
            if (code.getSmall().equals("00")) {
                // 중분류 생성
                currentVariety = ProductVariety.builder()
                        .code(code.getMid())
                        .name(code.getMidName())
                        .productItems(new ArrayList<>(items)) // 복사
                        .build();

                items.clear(); // 다음 아이템을 위해 초기화
                varieties.add(currentVariety);
                continue;
            }

            // 대분류 구분 조건
            if (code.getMid().equals("00")) {
                AgriculturalCategory category = AgriculturalCategory.builder()
                        .code(code.getLarge())
                        .name(code.getLargeName())
                        .build();

                // ProductVariety → AgriculturalCategory 관계 설정
                for (ProductVariety variety : varieties) {
                    variety.setAgriculturalCategory(category);
                }
                category.setProductVarieties(varieties);

                varieties = new ArrayList<>();
                categories.add(category);
            }
        }
        agriculturalCategoryRepository.saveAll(categories);
    }
}
