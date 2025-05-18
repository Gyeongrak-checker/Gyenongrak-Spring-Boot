package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WholesaleMarketsCode {
    @JsonProperty("whsl_mrkt_cd")
    private String wholesaleMarket;

    @JsonProperty("whsl_mrkt_nm")
    private String name;
}
