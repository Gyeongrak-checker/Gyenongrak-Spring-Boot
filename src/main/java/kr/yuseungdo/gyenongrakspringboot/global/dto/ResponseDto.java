package kr.yuseungdo.gyenongrakspringboot.global.dto;

import org.springframework.http.HttpStatusCode;

public record ResponseDto(
        HttpStatusCode code,
        String message
) {
}
