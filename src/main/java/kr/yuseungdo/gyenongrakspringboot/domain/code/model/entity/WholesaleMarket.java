package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// 도매 시장
@Entity
@Getter
@Builder
@ToString
@Table(name = "wholesale_market")
@AllArgsConstructor
@NoArgsConstructor
public class WholesaleMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;
}
