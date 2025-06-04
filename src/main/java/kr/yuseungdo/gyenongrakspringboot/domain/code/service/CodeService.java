package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template.ApiResponse;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template.Items;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


        List<ProductCode> codes = codeRequest.getProduct(0, productItemTotalCount).getItems();

        List<AgriculturalCategory> categories = new ArrayList<>();
        List<ProductVariety> varieties = new ArrayList<>();
        List<ProductItem> items = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            log.info("{}", codes.get(i));
        }


        for(ProductCode code : codes) {

            if(code.getMid().equals("00")) {
                AgriculturalCategory category = AgriculturalCategory.builder()
                        .code(code.getLarge())
                        .name(code.getLargeName())
                        .build();

                categories.add(category);
                continue;
            }

            if(code.getSmall().equals("00")) {
                ProductVariety variety = ProductVariety.builder()
                        .code(code.getSmall())
                        .name(code.getSmallName())
                        .build();

                varieties.add(variety);
                continue;
            }

            ProductItem item = ProductItem.builder()
                    .code(code.getSmall())
                    .name(code.getSmallName())
                    .build();

            items.add(item);
        }
    }
}
