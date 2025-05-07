package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.CodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class AtCodeRequest implements CodeRequest {

    private final WebClient webClient;

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


    @Value("api-key.code")
    private String apiKey;

    @Override
    public UnitApiResponse getUnits(int page, int row) {
        return webClient.get()
                .uri() // 중복 인코딩 의심
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UnitApiResponse.class)
                .block();
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
