package kr.yuseungdo.gyenongrakspringboot.global.event;

import kr.yuseungdo.gyenongrakspringboot.domain.code.api.at.AtCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartEventListener {

    private final AtCodeRequest codeRequest;
    private final

    @EventListener(ApplicationReadyEvent.class)
    void codeInit() {

    }
}
