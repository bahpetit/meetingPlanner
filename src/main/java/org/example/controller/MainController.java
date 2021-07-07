package org.example.controller;


import lombok.AllArgsConstructor;
import org.example.domain.Event;
import org.example.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final EventService evenService;

    @RequestMapping(value = "/")
    public String index() {
        return "Welcome!";
    }

    @GetMapping("/api/events")
    List<Event> events() {
        List<Event> events = evenService.findAll();
        return events;
    }

}
