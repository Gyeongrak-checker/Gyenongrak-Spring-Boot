package kr.yuseungdo.gyenongrakspringboot.domain.code.api;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.*;

import java.util.List;

public interface Request {
    List<UnitCodeDto> getUnits(int page, int row);
    List<SizeCodeDto> getSize(int page, int row);
    List<GradeCodDto> getGrades(int page, int row);
    List<CategoryCodeDto> getAgriculturalCategories(int page, int row);
    List<PackageCodeDto> getPackages(int page, int row);
}
