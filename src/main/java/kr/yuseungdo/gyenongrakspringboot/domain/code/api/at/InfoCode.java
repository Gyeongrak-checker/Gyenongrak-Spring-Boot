package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.CommonCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InfoCode implements CommonCode {
    GRADE("grd_cd", "grd_nm"),
    PACKAGE("pkg_cd", "pkg_nm"),
    SIZES("szs_cd", "szs_nm"),
    MARKET("whl_cd", "whl_nm"),
    COP("corp_cd", "corp_nm"),
    PRODUCT("prd_cd", "prd_nm")
    ;



    private final String code;
    private final String name;

    public static InfoCode fromCode(String code) {
        for (InfoCode uc : values()) {
            if (uc.code.equals(code)) {
                return uc;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 코드입니다: " + code);
    }
}