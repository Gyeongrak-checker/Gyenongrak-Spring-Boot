package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template.ApiResponse;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
        saveProduct();
    }

    private void saveProduct() {
        Map<String, ProductItem> itemMap = new HashMap<>();
        Map<String, ProductVariety> varietyMap = new HashMap<>();
        Map<String, AgriculturalCategory> categoryMap = new HashMap<>();

        List<ProductCode> productCodes = codeRequest.getProduct(1, productItemTotalCount).getItems();

        for (ProductCode code : productCodes) {
            // 소분류
            ProductItem item = itemMap.computeIfAbsent(code.getSmall(), k ->
                    ProductItem.builder().code(code.getSmall()).name(code.getSmallName()).build()
            );

            // 중분류
            ProductVariety variety = varietyMap.computeIfAbsent(code.getMid(), k ->
                    ProductVariety.builder().code(code.getMid()).name(code.getMidName()).productItems(new ArrayList<>()).build()
            );
            if (!variety.getProductItems().contains(item)) {
                variety.getProductItems().add(item);
            }

            // 대분류
            AgriculturalCategory category = categoryMap.computeIfAbsent(code.getLarge(), k ->
                    AgriculturalCategory.builder().code(code.getLarge()).name(code.getLargeName()).productVarieties(new ArrayList<>()).build()
            );
            if (!category.getProductVarieties().contains(variety)) {
                category.getProductVarieties().add(variety);
            }
        }

        productItemRepository.saveAll(itemMap.values());
        productVarietyRepository.saveAll(varietyMap.values());
        agriculturalCategoryRepository.saveAll(categoryMap.values());
    }
}
