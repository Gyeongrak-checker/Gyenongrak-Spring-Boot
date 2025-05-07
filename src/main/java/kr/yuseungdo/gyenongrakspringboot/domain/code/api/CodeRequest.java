package kr.yuseungdo.gyenongrakspringboot.domain.code.api;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.*;

import java.util.List;

// 경매시간, 품목, 산지, 거래량, 규격, 경락가

public interface CodeRequest {
    UnitApiResponse getUnits(int page, int row);
    List<SizeCodeDto> getSize(int page, int row);
    List<GradeCodDto> getGrades(int page, int row);
    List<CategoryCodeDto> getAgriculturalCategories(int page, int row);
    List<PackageCodeDto> getPackages(int page, int row);
}
