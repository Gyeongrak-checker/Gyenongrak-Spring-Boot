package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template;
import lombok.*;

import java.util.List;

@Data
public class ApiResponse<T> {
    private Response<T> response;

    public List<T> getItems() {
        return response.getBody().getItems().getItem();
    }

    public int getTotalCount() {
        return response.getBody().getTotalCount();
    }

    public int getPage() {
        return response.getBody().getPageNo();
    }
}