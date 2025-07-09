package kr.yuseungdo.gyenongrakspringboot.global.exception.type;

import kr.yuseungdo.gyenongrakspringboot.global.exception.error.ErrorCode;

public class ProductException extends RuntimeException {
    public ProductException(ErrorCode errorCode) {
        super(errorCode.getInfo());
    }
}
