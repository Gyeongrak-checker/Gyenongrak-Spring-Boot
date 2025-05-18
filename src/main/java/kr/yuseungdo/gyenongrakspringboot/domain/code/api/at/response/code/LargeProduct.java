package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LargeProduct {
    @JsonProperty("gds_lclsf_cd")
    private String large;

    @JsonProperty("gds_lclsf_nm")
    private String name;

    @JsonProperty("gds_mclsf_cd")
    private String child;
}
