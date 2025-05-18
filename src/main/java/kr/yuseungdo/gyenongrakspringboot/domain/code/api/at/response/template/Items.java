package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template;

import lombok.Data;

import java.util.List;

@Data
public class Items<T> {
    private List<T> item;
}
