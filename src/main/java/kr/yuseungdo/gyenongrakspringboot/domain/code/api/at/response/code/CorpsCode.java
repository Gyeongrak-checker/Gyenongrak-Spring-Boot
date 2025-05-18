package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CorpsCode {
    @JsonProperty("corp_cd")
    private String corps;

    @JsonProperty("corp_nm")
    private String name;
}
