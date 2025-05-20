package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template.ApiResponse;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.PlaceOrigins;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@Component
@RequiredArgsConstructor
public class AtCodeRequest {

    private final WebClient webClient;

    @Value("${api-key.code}")
    private String apiKey;

    private final String schema = "https";
    private final String host = "apis.data.go.kr";
    private final String codePath = "/B552845/katCode";


    private ResponseSpec request(int page, int row, ServicePath path) {
        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.scheme(schema).host(host).path(codePath + path.getPath())
                                .queryParam("serviceKey", apiKey)
                                .queryParam("page", page)
                                .queryParam("row", row)
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }

    public ApiResponse<UnitCode> getUnits(int page, int row) {
        return request(page, row, ServicePath.UNITS)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<UnitCode>>() {})
                .block();
    }

    public ApiResponse<SizesCode> getSize(int page, int row) {
        return request(page, row, ServicePath.SIZES)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<SizesCode>>() {})
                .block();
    }


    public ApiResponse<GradeCode> getGrades(int page, int row) {
        return request(page, row, ServicePath.GRADE)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<GradeCode>>() {})
                .block();
    }


    public ApiResponse<PackagingCode> getPackages(int page, int row) {
        return request(page, row, ServicePath.PACKAGE)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<PackagingCode>>() {})
                .block();
    }

    public ApiResponse<CorpsCode> getCorps (int page, int row) {
        return request(page, row, ServicePath.COP)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<CorpsCode>>() {})
                .block();
    }

    public ApiResponse<WholesaleMarketsCode> getMarket(int page, int row) {
        return request(page, row, ServicePath.MARKET)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<WholesaleMarketsCode>>() {})
                .block();
    }

    public ApiResponse<Product> getProduct(int page, int row) {
        return request(page, row, ServicePath.PRODUCT)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Product>>() {})
                .block();
    }

    public ApiResponse<PlaceOrigins> getPlaceOrigins(int page, int row) {
        return request(page, row, ServicePath.PLACEORIGIN)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<PlaceOrigins>>() {})
                .block();
    }

}
