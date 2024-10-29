package com.maxlvshv.eventshare.service;

import com.maxlvshv.eventshare.dto.EventScrollDto;
import com.maxlvshv.eventshare.entity.Event;
import com.maxlvshv.eventshare.entity.Status_enum;
import com.maxlvshv.eventshare.mapper.EventScrollMapper;
import com.maxlvshv.eventshare.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    private final EventScrollMapper eventScrollMapper;

    public Optional<List<Event>> findAll() {
        List<Event> events = eventRepository.findAll();
        return Optional.of(events);
    }

    public PagedModel<EventScrollDto> findAllDto(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);
        Page<EventScrollDto> eventScrollDtoPage = events.map(eventScrollMapper::toDto);
        return new PagedModel<>(eventScrollDtoPage);
    }

    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public Event updateEventStatusToCompleted(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setStatus(Status_enum.completed);
        return eventRepository.save(event);
    }

    public Event updateEventStatusToCanceled(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setStatus(Status_enum.canceled);
        return eventRepository.save(event);
    }
}
