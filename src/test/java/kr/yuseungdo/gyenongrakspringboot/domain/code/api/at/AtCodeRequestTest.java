package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template.ApiResponse;
import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class AtCodeRequestTest {

    @Autowired
    private AtCodeRequest codeRequest; // 빈으로 주입받기

    @Test
    void getAllCodeResponses() {
        // 단위 코드
        ApiResponse<UnitCode> units = codeRequest.getUnits(1, 100);
        assertApiResponse(units, "UnitCode");

        // 학년 코드
        ApiResponse<GradeCode> grades = codeRequest.getGrades(1, 100);
        assertApiResponse(grades, "GradeCode");

        // 생산자 코드
        ApiResponse<CorpsCode> corps = codeRequest.getCorps(1, 100);
        assertApiResponse(corps, "CorpsCode");

        // 포장 코드
        ApiResponse<PackagingCode> packages = codeRequest.getPackages(1, 100);
        assertApiResponse(packages, "PackagingCode");

        // 도매시장 코드
        ApiResponse<WholesaleMarketsCode> markets = codeRequest.getMarket(1, 100);
        assertApiResponse(markets, "WholesaleMarketsCode");

        // 산지 코드
        ApiResponse<PlaceOriginsCode> placeOrigins = codeRequest.getPlaceOrigins(1, 100);
        assertApiResponse(placeOrigins, "PlaceOriginsCode");

        // 상품
        ApiResponse<Product> product = codeRequest.getProduct(1, 100);
        assertApiResponse(product, "Product");
    }

    private <T> void assertApiResponse(ApiResponse<T> response, String name) {
        assertThat(response).as(name + " 응답이 null이 아니어야 합니다").isNotNull();
        assertThat(response.getResponse()).as(name + ".response 가 null이 아니어야 합니다").isNotNull();
        assertThat(response.getResponse().getBody()).as(name + ".body 가 null이 아니어야 합니다").isNotNull();
        assertThat(response.getResponse().getBody().getItems()).as(name + ".items 가 null이 아니어야 합니다").isNotNull();
        assertThat(response.getResponse().getBody().getItems().getItem())
                .as(name + ".items.item 리스트가 비어있지 않아야 합니다")
                .isNotNull()
                .isNotEmpty();
    }
}