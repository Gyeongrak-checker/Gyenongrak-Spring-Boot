package kr.yuseungdo.gyenongrakspringboot.global.api.at;

import kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code.*;
import kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@Slf4j
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
                                .queryParam("numOfRows", row)
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
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

    public ApiResponse<ProductCode> getProduct(int page, int row) {
        return request(page, row, ServicePath.PRODUCT)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<ProductCode>>() {})
                .block();
    }

    public ApiResponse<PlaceOriginsCode> getPlaceOrigins(int page, int row) {
        return request(page, row, ServicePath.PLACEORIGIN)
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<PlaceOriginsCode>>() {})
                .block();
    }

}
