package kr.yuseungdo.gyenongrakspringboot.global.event;

import kr.yuseungdo.gyenongrakspringboot.domain.code.service.CodeInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
@RequiredArgsConstructor
public class StartEventListener {

    private final CodeInitService codeService;

    @EventListener(ApplicationReadyEvent.class)
    void codeInit() {
        codeService.init();
    }
}
