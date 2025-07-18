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

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class AuctionMapper {
    private final WholesaleMarketRepository marketRepo;
    private final PackageRepository packageRepo;
    private final PlaceOriginsRepository originRepo;
    private final ProductItemRepository productItemRepository;
    private final GradeRepository gradeRepository;
    private final UnitsRepository unitsRepository;
    private final SizeRepository sizeRepository;

    public Auction toEntity(AuctionApiDto dto) {
        return Auction.builder()
                .wholesaleMarket(getMarket(dto.getMarketCode()))
                .productPackage(getPackage(dto.getPackageCode()))
                .home(getOrigin(dto.getOriginPlaceCode()))
                .productItem(getItem(dto))
                .auctionTime(dto.getAuctionTime())
                .price(dto.getPrice())
                .grade(getGrade(dto.getUnitCode()))
                .units(getUnit(dto.getUnitCode()))
                .build();
    }

    private WholesaleMarket getMarket(String code) {
        return marketRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "MARKET"));
    }

    private Package getPackage(String code) {
        return packageRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "PACKAGE"));
    }

    private PlaceOrigins getOrigin(String code) {
        return originRepo.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "ORIGIN"));
    }

    private Grade getGrade(String code) {
        return gradeRepository.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "GRADE"));
    }

    private Units getUnit(String code) {
        return unitsRepository.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "UNIT"));
    }

    private Sizes getSize(String code) {
        return sizeRepository.findByCode(code)
                .orElseThrow(() -> new ProductException(ProductCode.NOT_FOUND, code, "SIZE"));
    }

    private ProductItem getItem(AuctionApiDto dto) {
        String largeCode = dto.getLargeCode();
        String middleCode = dto.getMiddleCode();
        String smallCode = dto.getSmallCode();

        List<ProductItem> items = productItemRepository.findProductItemByCodes(smallCode, middleCode, largeCode);
        ProductItem item = items.isEmpty() ? null : items.get(0);

        return item;
    }
}
