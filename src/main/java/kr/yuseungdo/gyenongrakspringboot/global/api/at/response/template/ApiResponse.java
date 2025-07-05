package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.template;
import lombok.*;

import java.util.List;

@Data
public class ApiResponse<T> {
    private Response<T> response;

    public List<T> getItems() {
        return response.getBody().getItems().getItem();
    }
}