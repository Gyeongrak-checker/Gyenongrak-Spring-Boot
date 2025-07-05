package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template;

import lombok.Data;

@Data
public class Response<T> {
    private Header header;
    private Body<T> body;
}
