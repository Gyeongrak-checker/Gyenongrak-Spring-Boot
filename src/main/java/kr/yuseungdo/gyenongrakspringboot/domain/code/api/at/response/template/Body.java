package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template;

import lombok.Data;

@Data
public class Body<T> {
    private String dataType;
    private Items<T> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}
