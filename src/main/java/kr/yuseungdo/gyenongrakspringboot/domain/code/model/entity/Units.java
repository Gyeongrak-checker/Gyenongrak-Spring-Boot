package kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "units")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

}
