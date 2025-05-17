package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.InfoCode;
import lombok.*;

import java.util.List;

@Data
public class ApiResponse {
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
    private List<Item<InfoCode>> item;
}

@Setter
@ToString
@Getter
class Item<I extends InfoCode> {
    private String infoCode;
    private String name;
    private String code;
}