package com.spring.springcrudproject.controller;

import com.spring.springcrudproject.domain.Event;
import com.spring.springcrudproject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  добавляем аннотациюдля того чтобы система ожидала методов для обработки запросов по их типам

//  аннотация выдает нам напротив нее кофейное зерно :))
@Controller
public class EventController {

    //контроллер с сервиса берет данные
    @Autowired
    private EventService eventService;
    // мы описали зависимости и еще не проинициализировали контекст
    // (внедрение зависимостей ч/з конструктор(поле нужно финализировать)
    // или ч/з аннотацию @Autowired(меньше кода писать))

    @GetMapping("/") //вызывается при открытии нашего приложения
    public String listForm(Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events", events);
        return "eventList";
    }
    @GetMapping("/add")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "eventAddForm";
    }

    @PostMapping("/add")
    public String addEvent(Model model, @ModelAttribute("event") Event event) {
        String name = event.getName();
        String city = event.getCity();
        double price = event.getPrice();

        if(!name.isEmpty() && !city.isEmpty() && !(price<0)){
            eventService.add(event);
            return "redirect:/";
        }
        model.addAttribute("errorMsg",
                "Event name and city must be filled");
        return "eventAddForm";
    }

    @GetMapping ("/update/{id}")
    public String updateEventForm(Model model, @PathVariable Integer id){
        Event event = eventService.findById(id);
        model.addAttribute("event", event);
        model.addAttribute("id", id);
        return "eventUpdateForm";
    }
    @PutMapping ("/update/{id}")
    public String updateEvent (Model model,
                               @ModelAttribute("event") Event event,
                               @PathVariable Integer id) {
        String name = event.getName();
        String city = event.getCity();
        double price = event.getPrice();

        if (!name.isEmpty() && !city.isEmpty() && !(price < 0)){
            eventService.update(id, event);
            return "redirect:/";
        }
        model.addAttribute("errorMsg",
                "All fields must be filled");
        return "eventUpdateForm";
    }
    @DeleteMapping("/delete")
    public String deleteEvent(Integer id){
        eventService.remove(id);
        return "redirect:/";
    }
}

