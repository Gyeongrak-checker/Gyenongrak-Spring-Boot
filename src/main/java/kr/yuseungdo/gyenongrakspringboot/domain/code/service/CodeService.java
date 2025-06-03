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

        List<ProductCode> productCodes = codeRequest.getProduct(0, productItemTotalCount).getItems();
        saveProduct(productCodes);
    }

    private void saveProduct(List<ProductCode> productCodes) {
        // 중복 방지 및 계층 구성을 위한 맵
        Map<String, AgriculturalCategory> categoryMap = new HashMap<>();
        Map<String, ProductVariety> varietyMap = new HashMap<>();
        Map<String, List<ProductItem>> itemsByVariety = new HashMap<>();
        Map<String, String> varietyToCategory = new HashMap<>();

        for (ProductCode code : productCodes) {
            // ProductItem 생성 및 분류
            ProductItem item = code.toItemEntity();
            String varietyCode = code.getMid();
            String categoryCode = code.getLarge();

            itemsByVariety.computeIfAbsent(varietyCode, k -> new ArrayList<>()).add(item);
            varietyToCategory.put(varietyCode, categoryCode);

            // 중복 없는 ProductVariety 생성
            varietyMap.computeIfAbsent(varietyCode, k -> ProductVariety.builder()
                    .name(code.getMidName())
                    .code(varietyCode)
                    .build());

            // 중복 없는 AgriculturalCategory 생성
            categoryMap.computeIfAbsent(categoryCode, k -> AgriculturalCategory.builder()
                    .name(code.getLargeName())
                    .code(categoryCode)
                    .build());
        }

        // ProductVariety에 ProductItem 연결
        for (Map.Entry<String, ProductVariety> entry : varietyMap.entrySet()) {
            String varietyCode = entry.getKey();
            ProductVariety variety = entry.getValue();
            List<ProductItem> items = itemsByVariety.getOrDefault(varietyCode, new ArrayList<>());

            for (ProductItem item : items) {
                item.setProductVariety(variety); // 단방향이라도 연결 필요
            }
            variety.setProductItems(items);
        }

        // AgriculturalCategory에 ProductVariety 연결
        for (Map.Entry<String, AgriculturalCategory> entry : categoryMap.entrySet()) {
            String categoryCode = entry.getKey();
            AgriculturalCategory category = entry.getValue();

            List<ProductVariety> varieties = varietyMap.entrySet().stream()
                    .filter(e -> categoryCode.equals(varietyToCategory.get(e.getKey())))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            category.setProductVarieties(varieties);
        }

        // 최상위만 저장하면 Cascade로 모두 저장됨
        agriculturalCategoryRepository.saveAll(categoryMap.values());
    }
}
