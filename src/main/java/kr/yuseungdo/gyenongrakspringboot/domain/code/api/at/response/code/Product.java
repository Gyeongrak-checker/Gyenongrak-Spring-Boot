package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    @JsonProperty("gds_lclsf_cd")
    private String large;

    @JsonProperty("gds_lclsf_nm")
    private String largeName;

    @JsonProperty("gds_mclsf_cd")
    private String mid;

    @JsonProperty("gds_mclsf_nm")
    private String midName;

    @JsonProperty("gds_sclsf_cd")
    private String small;

    @JsonProperty("gds_sclsf_nm")
    private String smallName;
}
