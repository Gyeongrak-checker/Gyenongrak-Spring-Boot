package kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.response.template;
import lombok.*;

@Data
public class ApiResponse<T> {
    private Response<T> response;
}