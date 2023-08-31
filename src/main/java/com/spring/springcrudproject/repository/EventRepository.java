package com.spring.springcrudproject.repository;

import com.spring.springcrudproject.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class EventRepository {

    static List<Event> events = Arrays.asList(
            new Event("Concert", "Berlin"),
            new Event("Ice Show", "Prague"),
            new Event("Opera", "Rome"),
            new Event("Royal Variety Show", "Paris")
    );
    public List<Event> findAll(){
        return events;
    }

//create method
    public void save(Event event) {
        events.add(event);
    }
}
