package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final AtCodeRequest codeRequest;

    private final AgriculturalCategoryRepository agriculturalCategoryRepository;
    private final GradeRepository gradeRepository;
    private final PlaceOriginsRepository placeOriginsRepository;
    private final PackageRepository packageRepository;
    private final ProductItemRepository productItemRepository;
    private final WholesaleCoporationRepository wholesaleCoporationRepository;
    private final WholesaleMarketRepository wholesaleMarketRepository;


    @Value("${code.totalCount.corps}")
    private int corpsTotalCount;

    @Value("${code.totalCount.grades}")
    private int gradeTotalCount;

    @Value("${code.totalCount.sizes}")
    private int sizeTotalCount;

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

//    public void init() {
//        codeRequest.getCorps(1, corpsTotalCount);
//        codeRequest.getGrades(1, gradeTotalCount);
//        codeRequest.getMarket(1, wholesaleMarketTotalCount);
//        codeRequest.getProduct(1, productItemTotalCount);
//        codeRequest.getPackages(1, packageTotalCount);
//        codeRequest.getPlaceOrigins(1, homeTotalCount);
//        codeRequest.getMarket(1, wholesaleMarketTotalCount);
//    }

    public void init() {}
}
