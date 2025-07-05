package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template;

import lombok.Data;

@Data
public class Header {
    private String resultCode;
    private String resultMsg;
}
