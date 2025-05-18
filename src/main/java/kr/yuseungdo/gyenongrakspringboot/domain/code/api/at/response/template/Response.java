package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template;

import lombok.Data;

@Data
public class Response<T> {
    private Header header;
    private Body<T> body;
}
