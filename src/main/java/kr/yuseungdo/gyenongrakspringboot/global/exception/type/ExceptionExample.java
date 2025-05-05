package kr.yuseungdo.gyenongrakspringboot.global.exception.type;

import kr.yuseungdo.gyenongrakspringboot.global.exception.error.ErrorCode;
import org.springframework.web.client.HttpStatusCodeException;

public class ExceptionExample extends HttpStatusCodeException {
    public ExceptionExample(ErrorCode errorCode) {
        super(errorCode.getCode(), errorCode.getInfo());
    }
}
