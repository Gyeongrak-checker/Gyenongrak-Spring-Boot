package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template;

import lombok.Data;

import java.util.List;

@Data
public class Items<T> {
    private List<T> item;
}
