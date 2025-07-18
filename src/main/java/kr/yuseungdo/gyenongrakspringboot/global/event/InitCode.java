package kr.yuseungdo.gyenongrakspringboot.global.event;

import kr.yuseungdo.gyenongrakspringboot.domain.code.service.CodeInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitCode implements ApplicationRunner {

    private final CodeInitService codeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        codeService.init();
    }
}
