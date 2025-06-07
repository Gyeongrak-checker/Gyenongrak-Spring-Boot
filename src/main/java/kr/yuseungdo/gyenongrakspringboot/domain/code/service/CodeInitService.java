package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import jakarta.transaction.Transactional;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Package;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeInitService {

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

    @Value("${code.totalCount.placeOrigins}")
    private int placeOriginsCount;

    @Value("${code.totalCount.packagings}")
    private int packageTotalCount;

    @Value("${code.totalCount.goods}")
    private int productItemTotalCount;

    @Value("${code.totalCount.wholesaleMarkets}")
    private int wholesaleMarketTotalCount;

    @Transactional
    public void init() {
        productVarietyRepository.deleteAll();
        agriculturalCategoryRepository.deleteAll();
        productItemRepository.deleteAll();
//        wholesaleCoporationRepository.deleteAll();
//        wholesaleMarketRepository.deleteAll();
//        packageRepository.deleteAll();
//        placeOriginsRepository.deleteAll();
//        gradeRepository.deleteAll();


//        setGrade();
//        setPackage();
//        setWholesaleMarket();
//        setPlaceOrigins();
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
        List<CorpsCode> coporations = codeRequest.getCorps(0, corpsTotalCount).getItems();
        List<WholesaleMarketsCode> marketsCodes = codeRequest.getMarket(0, wholesaleMarketTotalCount).getItems();

        // 수산물은 빠져 있는 상태

        List<WholesaleMarket> marketEntities = new ArrayList<>();

        for (WholesaleMarketsCode marketsCode : marketsCodes) {
            List<WholesaleCoporation> coporationEntities = new ArrayList<>();

            WholesaleMarket market = WholesaleMarket.builder()
                    .code(marketsCode.getCode())
                    .name(marketsCode.getName())
                    .build();

            for (CorpsCode corpsCode : coporations) {
                if (corpsCode.getCode().substring(0, 6).equals(marketsCode.getCode())) {
                    WholesaleCoporation coporation = corpsCode.toEntity();
                    // 연관관계 설정
                    coporation.setWholesaleMarket(market); // 여기에 market이 필요하므로 위치 조정 필요
                    coporationEntities.add(coporation);
                }
            }

            market.setCoporations(coporationEntities);

            // 연관관계 주인 설정
            for (WholesaleCoporation coporation : coporationEntities) {
                coporation.setWholesaleMarket(market);  // 연관관계의 주인 설정
            }

            marketEntities.add(market);
        }
        wholesaleMarketRepository.saveAll(marketEntities);
    }

    private void setProductCodes() {
        List<ProductCode> codes = codeRequest.getProduct(0, productItemTotalCount).getItems();

        AgriculturalCategory currentCategory = null;
        ProductVariety currentVariety = null;

        for (ProductCode code : codes) {
            // 대분류
            if (code.getMid().equals("00")) {
                currentCategory = AgriculturalCategory.builder()
                        .code(code.getLarge())
                        .name(code.getLargeName())
                        .build();

                agriculturalCategoryRepository.save(currentCategory); // ✅ 먼저 저장
                continue;
            }

            // 중분류
            if (code.getSmall().equals("00")) {
                currentVariety = ProductVariety.builder()
                        .code(code.getMid())
                        .name(code.getMidName())
                        .category(currentCategory) // ✅ 저장된 category 참조
                        .build();

                productVarietyRepository.save(currentVariety); // ✅ 먼저 저장
                continue;
            }

            // 소분류
            ProductItem item = ProductItem.builder()
                    .code(code.getSmall())
                    .name(code.getSmallName())
                    .variety(currentVariety) // ✅ 저장된 variety 참조
                    .build();

            productItemRepository.save(item);
        }
    }
}
