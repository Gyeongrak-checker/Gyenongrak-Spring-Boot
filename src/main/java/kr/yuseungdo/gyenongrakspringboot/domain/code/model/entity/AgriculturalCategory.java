package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "agricultural_category")
@AllArgsConstructor
@NoArgsConstructor
public class AgriculturalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @OneToMany(mappedBy = "agriculturalCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductVariety> productVarieties;
}
