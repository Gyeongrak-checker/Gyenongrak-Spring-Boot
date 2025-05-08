package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.CodeRequest;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.UnitApiResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

class AtCodeRequestTest {

    private static final Logger log = LoggerFactory.getLogger(AtCodeRequestTest.class);

    @Test
    // 요청이 제대로 되는지 테스트
    void getUnits() {

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        WebClient webClient = WebClient.builder().uriBuilderFactory(factory).build();

        CodeRequest codeRequest = new AtCodeRequest(webClient);
        UnitApiResponse unitApiResponse = codeRequest.getUnits(1, 100);

        log.info(unitApiResponse.toString());
    }

}