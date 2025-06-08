package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.ProductDto;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.AgriculturalCategory;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductItem;
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


    public List<ProductDto> getLargeProducts() {
        return agriculturalCategoryRepository.findAll().stream().map(category -> ProductDto.builder()
                .code(category.getCode()).name(category.getName()).build()).toList();
    }

    public List<ProductDto> getMidProducts(String largeCode) {
    }

    public List<ProductDto> getSmallProducts(String largeCode, String midCode) {

    }
}
