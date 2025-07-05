package kr.yuseungdo.gyenongrakspringboot.global.api.at.response.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.yuseungdo.gyenongrakspringboot.domain.code.model.entity.Package;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PackagingCode {
    @JsonProperty("pkg_cd")
    private String packaging;
    @JsonProperty("pkg_nm")
    private String name;

    public Package toEntity() {
        return Package.builder().code(this.packaging).name(this.name).build();
    }
}
