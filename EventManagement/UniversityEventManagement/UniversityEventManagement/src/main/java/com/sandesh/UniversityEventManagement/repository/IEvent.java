package com.sandesh.UniversityEventManagement.repository;

import com.sandesh.UniversityEventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IEvent extends JpaRepository<Event,Long> {
    List<Event> findAllByDate(LocalDate date);
}
