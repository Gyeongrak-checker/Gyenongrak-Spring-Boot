package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 도매 법인
@Entity
@Getter
@Table(name = "wholesale_coporation")
@NoArgsConstructor
public class WholesaleCoporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

}
