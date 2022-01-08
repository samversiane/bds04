package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public Page<EventDTO> findAllPaged(Pageable pageable) {

        Page<Event> page = eventRepository.findAll(pageable);
        return page.map(x -> new EventDTO(x));
    }

    @Transactional
    public EventDTO insert(EventDTO eventDTO) {

        Event entity = new Event();
        entity.setId(eventDTO.getId());
        entity.setName(eventDTO.getName());
        entity.setDate(eventDTO.getDate());
        entity.setUrl(eventDTO.getUrl());
        entity.setCity(new City(eventDTO.getCityId(), null));
        entity = eventRepository.save(entity);
        return new EventDTO(entity);
    }
}
