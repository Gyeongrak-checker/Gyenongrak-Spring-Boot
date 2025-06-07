package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
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

    private String code;
}
