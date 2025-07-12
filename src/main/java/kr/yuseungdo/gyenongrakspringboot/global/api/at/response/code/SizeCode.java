package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Sizes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeCode {

    @JsonProperty("sz_cd")
    private String code;

    @JsonProperty("sz_nm")
    private String name;

    public Sizes toEntity() {
        return Sizes.builder().code(this.code).name(this.name).build();
    }

}
