package kr.yuseungdo.gyenongrakspringboot.global.event;

import kr.yuseungdo.gyenongrakspringboot.domain.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartEventListener {

    private final CodeService codeService;

    @EventListener(ApplicationReadyEvent.class)
    void codeInit() {
        codeService.init();
    }
}
