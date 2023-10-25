package com.sandesh.UniversityEventManagement.service;

import com.sandesh.UniversityEventManagement.model.Event;
import com.sandesh.UniversityEventManagement.repository.IEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    IEvent iEvent;

    public String addEvent(Event event) {
        iEvent.save(event);
        return "event added";
    }

    public String updateEvent(Long id, Event event) {
        Event existingEvent = iEvent.findById(id).orElse(null);
        existingEvent.setEventName(event.getEventName());
        existingEvent.setLocationOfEvent(event.getLocationOfEvent());
        existingEvent.setDate(event.getDate());
        existingEvent.setStartTime(event.getStartTime());
        existingEvent.setEndTime(event.getEndTime());
        iEvent.save(existingEvent);
        return "event updated successfully";
    }

    public String removeEventById(Long id) {
        if (iEvent.existsById(id)) {
             iEvent.deleteById(id);
            return "Event deleted successfully!";
        } else {
            return "Event not found!";
        }
    }

    public List<Event> getAllEventByDate(LocalDate date) {
        return iEvent.findAllByDate(date);
    }
}
