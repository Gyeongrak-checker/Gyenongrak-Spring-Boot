package kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UnitApiResponse {
    private Response response;
}

@Data
class Response {
    private Header header;
    private Body body;
}

@Data
class Header {
    private String resultCode;
    private String resultMsg;
}

@Data
class Body {
    private String dataType;
    private Items items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}

@Data
class Items {
    private List<Item> item;
}

@Data
class Item {
    private String unit_cd;
    private String unit_nm;
}

