package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 도매 법인
@Entity
@Getter
@Builder
@Table(name = "wholesale_coporation")
@AllArgsConstructor
@NoArgsConstructor
public class WholesaleCoporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wholesale_market_id")
    private WholesaleMarket wholesaleMarket;
}
