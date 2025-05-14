package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse<T extends CommonCode> {
    private Response<T> response;
}

@Data
class Response <T extends CommonCode>{
    private Header header;
    private Body<T> body;
}

@Data
class Header {
    private String resultCode;
    private String resultMsg;
}

@Data
class Body <T extends CommonCode> {
    private String dataType;
    private Items<T> items;
    private int numOfRows;
    private int pageNo;
    private int totalCount;
}

@Data
class Items<T extends CommonCode> {
    private List<T> item;
}
