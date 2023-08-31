package com.spring.springcrudproject.controller;

import com.spring.springcrudproject.domain.Event;
import com.spring.springcrudproject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "listView";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        return "addFormView";
    }

    @PostMapping
    public String addPost(){
        return null;
    }
}
