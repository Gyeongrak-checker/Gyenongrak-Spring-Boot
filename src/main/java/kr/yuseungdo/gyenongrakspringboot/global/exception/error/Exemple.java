package kr.yuseungdo.gyenongrakspringboot.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public enum Exemple implements ErrorCode {
    EX(HttpStatus.INTERNAL_SERVER_ERROR, "테스트"),
    ;

    private final HttpStatusCode code;
    private final String info;
}
