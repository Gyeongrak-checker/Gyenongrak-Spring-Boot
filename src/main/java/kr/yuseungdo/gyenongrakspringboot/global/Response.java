package kr.yuseungdo.gyenongrakspringboot.global;

import kr.yuseungdo.gyenongrakspringboot.global.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class Response {

    public static ResponseEntity<ResponseDto> ERROR(Exception ex) {
        log.warn(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류"));
    }

    public static ResponseEntity OK() {
        return ResponseEntity.ok().build();
    }

    public static <T> ResponseEntity<T> OK(T data) {
        return ResponseEntity.ok(data);
    }
}
