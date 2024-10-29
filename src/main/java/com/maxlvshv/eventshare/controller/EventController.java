package com.maxlvshv.eventshare.controller;

import com.maxlvshv.eventshare.dto.EventScrollDto;
import com.maxlvshv.eventshare.entity.Event;
import com.maxlvshv.eventshare.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> findAll() {
        Optional<List<Event>> eventsOptional = eventService.findAll();
        List<Event> events = eventsOptional.orElse(null);
        return ResponseEntity.ok(events);
    }

    @GetMapping
    public PagedModel<EventScrollDto> getList(Pageable pageable) {
        return eventService.findAllDto(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        Optional<Event> eventOptional = eventService.findById(id);
        Event event = eventOptional.orElse(null);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event entity) {
        Event event = eventService.save(entity);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public Event delete(@PathVariable Long id) {
        Event event = eventService.findById(id).orElse(null);
        if (event != null) {
            eventService.deleteById(id);
        }
        return event;
    }


    @PutMapping("/{id}/comp")
    public ResponseEntity<Event> updateEventStatusToCompleted(@PathVariable Long id) {
        Event event = eventService.updateEventStatusToCompleted(id);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/{id}/canc")
    public ResponseEntity<Event> updateEventStatusToCanceled(@PathVariable Long id) {
        Event event = eventService.updateEventStatusToCanceled(id);
        return ResponseEntity.ok(event);
    }
}

