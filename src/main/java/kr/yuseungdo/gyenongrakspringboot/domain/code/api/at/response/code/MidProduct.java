package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MidProduct {

    @JsonProperty("gds_mclsf_cd")
    private String middle;

    @JsonProperty("gds_mclsf_nm")
    private String name;

    @JsonProperty("gds_lclsf_cd")
    private String parent;

    @JsonProperty("gds_sclsf_cd")
    private String child;
}
