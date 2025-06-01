package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleCoporation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CorpsCode {
    @JsonProperty("corp_cd")
    private String corps;

    @JsonProperty("corp_nm")
    private String name;

    @ManyToOne
    private WholesaleCoporation wholesaleCoporation;
}
