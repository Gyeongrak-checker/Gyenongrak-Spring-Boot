package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.request.UnitApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AtCodeRequestTest {

    @Autowired
    private AtCodeRequest codeRequest; // 빈으로 주입받기

    @Test
    void getUnits() {
        UnitApiResponse unitApiResponse = codeRequest.getUnits(1, 100);
        System.out.println(unitApiResponse.toString());
    }
}