package org.example.service;

import lombok.AllArgsConstructor;
import org.example.domain.Event;
import org.example.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EventService {


    private final EventRepository eventRepository;

    public List<Event> findAll() {
        List<Event> events = eventRepository.findAll();
        return events;
    }
}
