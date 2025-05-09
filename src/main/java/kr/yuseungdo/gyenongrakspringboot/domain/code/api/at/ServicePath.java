package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServicePath implements RequestPath {
    UNITS("/units"),
    GRADE("/grade"),
    PACKAGE("/packagings"),
    SIZES("/sizes"),
    MARKET("/wholesaleMarkets"),
    COP("/corps"),
    PRODUCT("/goods")
    ;
    private final String path;
}
