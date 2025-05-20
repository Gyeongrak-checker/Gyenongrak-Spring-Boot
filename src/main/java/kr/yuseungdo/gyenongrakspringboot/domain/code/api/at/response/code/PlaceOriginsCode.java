package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceOriginsCode {
    @JsonProperty("plor_cd")
    private String placeOrigins;
    @JsonProperty("plor_nm")
    private String name;
}
