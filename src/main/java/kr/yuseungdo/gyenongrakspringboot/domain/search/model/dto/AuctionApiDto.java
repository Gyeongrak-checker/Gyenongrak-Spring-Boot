package kr.yuseungdo.gyenongrakspringboot.domain.search.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@AllArgsConstructor
public class AuctionApiDto {

    @JsonProperty("scsbd_dt")
    private String auctionTime;

    @JsonProperty("whsl_mrkt_cd")
    private String marketCode;

    @JsonProperty("corp_cd")
    private String corpCode;

    @JsonProperty("unit_cd")
    private String unitCode;

    @JsonProperty("pkg_cd")
    private String packageCode;

    @JsonProperty("plor_cd")
    private String originPlaceCode;

    @JsonProperty("gds_sclsf_cd")
    private String itemCode;

    @JsonProperty("scsbd_prc")
    private String price;

    public Date getAuctionTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(auctionTime);
        } catch (Exception e) {
            throw new RuntimeException("날짜 파싱 오류: " + auctionTime);
        }
    }

    public int getPrice() {
        return Integer.parseInt(price);
    }
}
