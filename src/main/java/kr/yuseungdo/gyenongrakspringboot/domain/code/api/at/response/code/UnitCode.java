package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnitCode {
    @JsonProperty("unit_cd")
    private String unit;

    @JsonProperty("unit_nm")
    private String name;
}
