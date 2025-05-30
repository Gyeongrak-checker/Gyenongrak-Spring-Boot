package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.PlaceOrigins;
import lombok.*;

@Getter
@Setter
public class PlaceOriginsCode {
    @JsonProperty("plor_cd")
    private String placeOrigins;
    @JsonProperty("plor_nm")
    private String name;

    public PlaceOrigins toEntity() {
        return PlaceOrigins.builder().code(this.placeOrigins).name(this.name).build();
    }
}
