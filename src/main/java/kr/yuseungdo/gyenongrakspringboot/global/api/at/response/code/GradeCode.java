package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GradeCode {
    @JsonProperty("grd_cd")
    private String grade;
    @JsonProperty("grd_nm")
    private String name;

}
