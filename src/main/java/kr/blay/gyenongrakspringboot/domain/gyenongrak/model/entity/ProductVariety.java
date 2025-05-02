package kr.blay.gyenongrakspringboot.domain.gyenongrak.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_variety")
public class ProductVariety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private AgriculturalCategory category;
}
