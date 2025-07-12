package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Units;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitsCode {

    @JsonProperty("unit_cd")
    private String code;

    @JsonProperty("unit_nm")
    private String name;

    public Units toEntity() {
        return Units.builder().code(this.code).name(this.name).build();
    }
}
