package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_variety")
public class ProductVariety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductItem> productItems;
}
