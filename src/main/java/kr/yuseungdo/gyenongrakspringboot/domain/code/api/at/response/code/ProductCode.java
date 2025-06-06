package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.AgriculturalCategory;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductItem;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.ProductVariety;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ProductCode {
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
