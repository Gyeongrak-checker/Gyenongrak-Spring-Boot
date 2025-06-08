package kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductDto {
    private String code;
    private String name;
}
