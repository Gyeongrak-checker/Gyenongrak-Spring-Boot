package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizesCode {

    @JsonProperty("sz_cd")
    private String size;

    @JsonProperty("sz_nm")
    private String name;
}
