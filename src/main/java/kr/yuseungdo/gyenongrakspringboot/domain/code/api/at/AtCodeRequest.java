package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    public ApiResponse getUnits(int page, int row) {
        return request(page, row, ServicePath.UNITS)
                .bodyToMono(ApiResponse.class)
                .block();
    }


//    public SizeApiResponse getSize(int page, int row) {
//        return request(page, row, ServicePath.SIZES)
//                .bodyToMono(SizeApiResponse.class)
//                .block();
//    }
//
//
//    public GradeApiResponse getGrades(int page, int row) {
//        return request(page, row, ServicePath.GRADE)
//                .bodyToMono(GradeApiResponse.class)
//                .block();
//    }
//
//
//    public PackageApiResponse getPackages(int page, int row) {
//        return request(page, row, ServicePath.PACKAGE)
//                .bodyToMono(PackageApiResponse.class)
//                .block();
//    }
}
