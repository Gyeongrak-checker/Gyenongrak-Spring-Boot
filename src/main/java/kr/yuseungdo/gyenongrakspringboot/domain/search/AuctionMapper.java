package kr.yuseungdo.gyenongrakspringboot.domain.search;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Package;
import kr.yuseungdo.gyenongrakspringboot.domain.code.repository.*;
import kr.yuseungdo.gyenongrakspringboot.domain.search.model.dto.AuctionApiDto;
import kr.yuseungdo.gyenongrakspringboot.domain.search.model.entity.Auction;
import kr.yuseungdo.gyenongrakspringboot.global.exception.error.ProductCode;
import kr.yuseungdo.gyenongrakspringboot.global.exception.type.ProductException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AuctionMapper {
    private final WholesaleMarketRepository marketRepo;
    private final AgriculturalCategoryRepository categoryRepo;
    private final ProductVarietyRepository varietyRepo;
    private final PackageRepository packageRepo;
    private final PlaceOriginsRepository originRepo;
    private final ProductItemRepository itemRepo;

    public Auction toEntity(AuctionApiDto dto) {


        log.info("dto: {}", dto);

        return Auction.builder()
                .wholesaleMarket(getMarket(dto.getMarketCode()))
                .productVariety(getVariety(dto.getUnitCode()))
                .productPackage(getPackage(dto.getPackageCode()))
                .home(getOrigin(dto.getOriginPlaceCode()))
                .productItem(getItem(dto.getItemCode()))
                .auctionTime(dto.getAuctionTime())
                .price(dto.getPrice()) // 가격은 따로 넣거나 계산 필요
                .build();
    }

    private WholesaleMarket getMarket(String code) {
        return marketRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }

    private AgriculturalCategory getAgriculturalCategory(String code) {
        return categoryRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }

    private ProductVariety getVariety(String unitCode) {
        return varietyRepo.findByCode(unitCode)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }

    private Package getPackage(String code) {
        return packageRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }

    private PlaceOrigins getOrigin(String code) {
        return originRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }

    private ProductItem getItem(String code) {
        return itemRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOTFOUND));
    }
}
