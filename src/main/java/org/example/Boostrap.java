package org.example;

import lombok.AllArgsConstructor;
import org.example.service.InitializationService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class Boostrap {
    private final InitializationService initializationService;

    @PostConstruct
    private void loading(){
        this.initializationService.loadingRoom();
        this.initializationService.loadingMeeting();
        this.initializationService.initEvent();
    }
}
