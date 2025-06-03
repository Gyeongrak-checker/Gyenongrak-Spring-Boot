package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// 부류
@Entity
@Getter
@Builder
@ToString
@Table(name = "agricultural_category")
@AllArgsConstructor
@NoArgsConstructor
public class AgriculturalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(fetch = FetchType.LAZY)
    List<ProductVariety> productVarieties;
}
