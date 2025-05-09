package kr.yuseungdo.gyenongrakspringboot.domain.code.service;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final AtCodeRequest codeRequest;



}
