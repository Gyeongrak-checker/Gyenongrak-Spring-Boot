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

        // 크기 코드
        ApiResponse<SizesCode> sizes = codeRequest.getSize(1, 100);
        assertApiResponse(sizes, "SizesCode");

        // 포장 코드
        ApiResponse<PackagingCode> packages = codeRequest.getPackages(1, 100);
        assertApiResponse(packages, "PackagingCode");

        // 도매시장 코드
        ApiResponse<WholesaleMarketsCode> markets = codeRequest.getMarket(1, 100);
        assertApiResponse(markets, "WholesaleMarketsCode");

        // 대분류 상품
        ApiResponse<LargeProduct> large = codeRequest.getLargeProduct(1, 100);
        assertApiResponse(large, "LargeProduct");

        // 중분류 상품
        ApiResponse<MidProduct> mid = codeRequest.getMidProduct(1, 100);
        assertApiResponse(mid, "MidProduct");

        // 소분류 상품
        ApiResponse<SmallProduct> small = codeRequest.getSmallProduct(1, 100);
        assertApiResponse(small, "SmallProduct");
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