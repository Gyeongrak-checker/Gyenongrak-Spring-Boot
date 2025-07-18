package kr.yuseungdo.gyenongrakspringboot.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public enum ProductCode implements ErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "해당 코드는 없습니디."),
    ;

    private final HttpStatusCode code;
    private final String info;
}
