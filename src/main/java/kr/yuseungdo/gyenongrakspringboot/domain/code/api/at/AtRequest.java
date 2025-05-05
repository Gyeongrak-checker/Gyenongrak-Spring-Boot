package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.Request;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AtRequest implements Request {

    private static final String REQUEST_URL = "https://apis.data.go.kr/B552845/katCode";

    private static final Map<String, String> UNITS = Map.of(
        "units", "/units",
        "grade", "/grade",
        "package", "/packagings",
        "sizes", "/sizes",
        "markets", "/wholesaleMarkets",
        "cop", "/corps",
        "product", "/goods"
    );


    @Value("api-key")
    private String apiKey;

    @Override
    public List<UnitCodeDto> getUnits(int page, int row) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SizeCodeDto> getSize(int page, int row) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<GradeCodDto> getGrades(int page, int row) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<CategoryCodeDto> getAgriculturalCategories(int page, int row) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<PackageCodeDto> getPackages(int page, int row) {
        throw new UnsupportedOperationException();
    }
}
