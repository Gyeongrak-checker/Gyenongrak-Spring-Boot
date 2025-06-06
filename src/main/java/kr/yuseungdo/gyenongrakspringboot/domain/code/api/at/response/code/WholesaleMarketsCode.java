package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleCoporation;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.WholesaleMarket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WholesaleMarketsCode {
    @JsonProperty("whsl_mrkt_cd")
    private String code;

    @JsonProperty("whsl_mrkt_nm")
    private String name;

    @OneToMany(mappedBy = "wholesaleMarket", fetch = FetchType.LAZY)
    List<WholesaleCoporation> coporations;

    public WholesaleMarket toEntity(List<WholesaleCoporation> coporations) {
        return WholesaleMarket.builder().code(this.code).name(this.name).coporations(coporations).build();
    }
}
