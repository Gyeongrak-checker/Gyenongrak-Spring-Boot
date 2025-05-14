package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response;

public class UnitCode implements CommonCode {

    private String grd_cd;
    private String grd_nm;

    @Override
    public String getCode() {
        return grd_cd;
    }

    @Override
    public String getName() {
        return grd_nm;
    }
}
