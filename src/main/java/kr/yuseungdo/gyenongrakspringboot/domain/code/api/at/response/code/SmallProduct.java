package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmallProduct {

    @JsonProperty("gds_sclsf_cd")
    private String small;

    @JsonProperty("gds_sclsf_nm")
    private String name;

    @JsonProperty("gds_mclsf_cd")
    private String parent;
}
