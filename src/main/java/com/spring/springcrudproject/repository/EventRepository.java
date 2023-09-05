package com.spring.springcrudproject.repository;

import com.spring.springcrudproject.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository {

    static List<Event> events = new ArrayList<>(Arrays.asList(
            new Event("Concert", "Berlin",120.00),
            new Event("Ice Show", "Prague",95.00),
            new Event("Opera", "Rome",60.00),
            new Event("Royal Variety Show", "Paris",110.00),
            new Event("Swan Lake Ballet", "Saint Petersburg",50.00)
    ));
    public List<Event> findAll(){
        return events;
    }

//create method
    public void save(Event event) {
        events.add(event);
    }

    public void save(Integer id, Event event) {
        Event updateEvent = events.get(id);
        updateEvent.setName(event.getName());
        updateEvent.setCity(event.getCity());
        updateEvent.setPrice(event.getPrice());
    }

    public Event findById(Integer id) {
        return events.get(id);
    }

    public void remove(int id) {
        events.remove(id);
    }
}
