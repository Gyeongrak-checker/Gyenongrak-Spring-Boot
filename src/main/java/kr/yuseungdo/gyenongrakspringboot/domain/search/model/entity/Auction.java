package kr.yuseungdo.gyenongrakspringboot.domain.search.model.entity;

import jakarta.persistence.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.*;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Package;
import lombok.*;

import java.util.Date;

// 경매 정보
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private WholesaleMarket wholesaleMarket;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package productPackage;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private PlaceOrigins home;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne
    @JoinColumn(name = "units_id")
    private Units units;

    @ManyToOne
    @JoinColumn(name = "sizes_id")
    private Sizes sizes;

    private int price;

    private Date auctionTime;
}
