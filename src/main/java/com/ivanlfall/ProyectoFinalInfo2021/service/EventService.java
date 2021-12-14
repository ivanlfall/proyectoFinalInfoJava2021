package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;
import com.ivanlfall.ProyectoFinalInfo2021.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }
    public List<Event> getAll(){
        return repository.findAll();
    }
    public Optional<Event> getEventById(Long id){
        return repository.findById(id);
    }
    public Event save(Event event){
        return repository.save(event);
    }
    public void delete(Event event){
        repository.delete(event);
    }
}
