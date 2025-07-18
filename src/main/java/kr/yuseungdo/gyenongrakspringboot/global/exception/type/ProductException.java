package kr.yuseungdo.gyenongrakspringboot.global.exception.type;

import kr.yuseungdo.gyenongrakspringboot.global.exception.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductException extends RuntimeException {
    public ProductException(ErrorCode errorCode, String code, String from) {
        super(errorCode.getInfo());
        log.warn("코드 이슈 발생 CODE: {} 발생 지점: :{}", code, from);
    }
}
