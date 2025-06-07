package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.*;

// 도매 법인
@Entity
@Getter
@Builder
@ToString
@Table(name = "wholesale_coporation")
@AllArgsConstructor
@NoArgsConstructor
public class WholesaleCoporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private WholesaleMarket wholesaleMarket;
}
