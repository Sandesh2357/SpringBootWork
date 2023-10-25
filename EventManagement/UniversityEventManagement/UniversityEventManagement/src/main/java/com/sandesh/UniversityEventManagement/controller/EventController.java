package com.sandesh.UniversityEventManagement.controller;

import com.sandesh.UniversityEventManagement.model.Event;
import com.sandesh.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("event")
    public String addEvent(@Valid @RequestBody Event event){
        return eventService.addEvent(event);
    }
    @PutMapping("event/id/{id}")
    public String updateEvent(@PathVariable Long id, @Valid @RequestBody Event event){
        return eventService.updateEvent(id,event);
    }
    @DeleteMapping("event/id/{id}")
    public String removeEventById(@PathVariable Long id){
        return eventService.removeEventById(id);
    }
    @GetMapping("event/date/{date}")
    public List<Event> getAllEventByDate(@PathVariable LocalDate date){
        return eventService.getAllEventByDate(date);
    }
}
