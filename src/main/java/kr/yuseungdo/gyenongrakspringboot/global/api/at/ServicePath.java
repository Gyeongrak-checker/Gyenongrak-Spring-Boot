package kr.yuseungdo.gyenongrakspringboot.global.api.at;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServicePath implements RequestPath {
    UNITS("/units"),
    GRADE("/grades"),
    PACKAGE("/packagings"),
    SIZES("/sizes"),
    MARKET("/wholesaleMarkets"),
    COP("/corps"),
    PLACEORIGIN("/placeOrigins"),
    PRODUCT("/goods")
    ;
    private final String path;
}
