package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Grade;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GradeCode {
    @JsonProperty("grd_cd")
    private String grade;
    @JsonProperty("grd_nm")
    private String name;

    public Grade toEntity() {
        return Grade.builder().code(this.grade).name(this.name).build();
    }
}
