package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// 도매 시장
@Entity
@Getter
@Builder
@Table(name = "wholesale_market")
@AllArgsConstructor
@NoArgsConstructor
public class WholesaleMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(fetch = FetchType.LAZY)
    private List<WholesaleCoporation> coporations;
}
