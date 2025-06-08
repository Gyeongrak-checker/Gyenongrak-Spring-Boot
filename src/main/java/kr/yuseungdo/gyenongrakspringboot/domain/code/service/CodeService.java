package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.Product;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductItem;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CodeService {

    private final AgriculturalCategoryRepository agriculturalCategoryRepository;
    private final ProductVarietyRepository productVarietyRepository;
    private final ProductItemRepository productItemRepository;

    private final WholesaleMarketRepository wholesaleMarketRepository;
    private final WholesaleCoporationRepository wholesaleCoporationRepository;

    private final GradeRepository gradeRepository;
    private final PlaceOriginsRepository placeOriginsRepository;
    private final PackageRepository packageRepository;


    public List<Product> getLargeProducts() {

    }

    public List<Product> getMidProducts() {

    }

    public List<Product> getSmallProducts() {

    }
}
