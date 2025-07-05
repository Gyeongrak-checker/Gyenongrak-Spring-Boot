package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleCoporation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CorpsCode {
    @JsonProperty("corp_cd")
    private String code;

    @JsonProperty("corp_nm")
    private String name;

    public WholesaleCoporation toEntity() {
        return WholesaleCoporation.builder().code(this.code).name(this.name).build();
    }
}
