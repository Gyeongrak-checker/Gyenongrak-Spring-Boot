package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// 도매 시장
@Entity
@Getter
@Table(name = "wholesale_market")
@NoArgsConstructor
public class WholesaleMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "wholesaleMarket")
    private List<WholesaleCoporation> coporations;
}
