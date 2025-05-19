package kr.yuseungdo.gyenongrakspringboot.domain.code.controller;

import kr.yuseungdo.gyenongrakspringboot.domain.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;


}
