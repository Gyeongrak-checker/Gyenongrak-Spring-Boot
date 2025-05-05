package kr.yuseungdo.gyenongrakspringboot.global.exception;

import kr.yuseungdo.gyenongrakspringboot.global.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity itineraryException(Exception ex) {
        return Response.ERROR(ex);
    }

}
