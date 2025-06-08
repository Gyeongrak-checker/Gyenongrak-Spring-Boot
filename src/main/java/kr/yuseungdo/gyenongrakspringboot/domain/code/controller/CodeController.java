package kr.yuseungdo.gyenongrakspringboot.domain.code.controller;

import kr.yuseungdo.gyenongrakspringboot.domain.code.model.dto.ProductDto;
import kr.yuseungdo.gyenongrakspringboot.domain.code.service.CodeService;
import kr.yuseungdo.gyenongrakspringboot.global.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/large")
    public ResponseEntity<List<ProductDto>> getLargeCode() {
        List<ProductDto> largeProducts = codeService.getLargeProducts();
        return Response.OK(largeProducts);
    }

    @GetMapping("/mid")
    public ResponseEntity<List<ProductDto>> getMidCode(@Param("largeCode") String largeCode) {
        log.info("largeCode = {}", largeCode);
        List<ProductDto> midProducts = codeService.getMidProducts(largeCode);
        return Response.OK(midProducts);
    }

    @GetMapping("/small")
    public ResponseEntity<List<ProductDto>> getSmallCode(@Param("largeCode") String midCode) {
        List<ProductDto> largeProducts = codeService.getSmallProducts(midCode);
        return Response.OK(largeProducts);
    }

}
