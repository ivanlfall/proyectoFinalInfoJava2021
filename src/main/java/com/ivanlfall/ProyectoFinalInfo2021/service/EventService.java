package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;
import com.ivanlfall.ProyectoFinalInfo2021.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        Event event = repository.findById(id).get();
        Collections.sort(event.getSubscribers(),
                (e1, e2) -> ((Integer)e1.getVotes().size()).compareTo(e2.getVotes().size()));
        Collections.reverse(event.getSubscribers());

        return Optional.of(event);
    }
    public Event save(Event event){
        return repository.save(event);
    }
    public void delete(Event event){
        repository.delete(event);
    }
}
