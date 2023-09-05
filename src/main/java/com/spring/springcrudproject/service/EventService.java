package com.spring.springcrudproject.service;

import com.spring.springcrudproject.domain.Event;
import com.spring.springcrudproject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll(){

        return eventRepository.findAll();
    }
    public void add(Event event){

        eventRepository.save(event);
    }
    public Event findById(Integer id){
        return eventRepository.findById(id);
    }

    public void update(Integer id, Event event) {
        eventRepository.save(id, event);
    }

    public void remove(Integer id) {
        eventRepository.remove(id);
    }
}
