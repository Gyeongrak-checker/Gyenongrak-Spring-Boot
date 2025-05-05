package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;


import jakarta.persistence.*;
import lombok.Getter;

// 부류
@Entity
@Getter
@Table(name = "agricultural_category")
public class AgriculturalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

}
