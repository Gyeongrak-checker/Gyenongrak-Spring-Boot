package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.ProductDto;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CodeService {

    private final AgriculturalCategoryRepository agriculturalCategoryRepository;
    private final ProductVarietyRepository productVarietyRepository;
    private final ProductItemRepository productItemRepository;

    private final WholesaleMarketRepository wholesaleMarketRepository;
    private final WholesaleCoporationRepository wholesaleCoporationRepository;

    private final PlaceOriginsRepository placeOriginsRepository;
    private final PackageRepository packageRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> getLargeProducts() {
        return agriculturalCategoryRepository.findAll().stream().map(category -> ProductDto.builder()
                .code(category.getCode()).name(category.getName()).build()).toList();
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getMidProducts(String largeCode) {
        return productVarietyRepository.findAllByCategoryCode(largeCode).stream().map(variety -> ProductDto.builder()
                .code(variety.getCode()).name(variety.getName()).build()).toList();
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getSmallProducts(String midCode) {
        return productItemRepository.findAllByVarietyCode(midCode).stream().map(productItem -> ProductDto.builder()
                .code(productItem.getCode()).name(productItem.getName()).build()).toList();
    }
}
