package com.ivanlfall.ProyectoFinalInfo2021.controller;

import com.ivanlfall.ProyectoFinalInfo2021.dto.EventDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;
import com.ivanlfall.ProyectoFinalInfo2021.entity.mapper.EventMapper;
import com.ivanlfall.ProyectoFinalInfo2021.service.EntrepreneurshipService;
import com.ivanlfall.ProyectoFinalInfo2021.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService service;
    private final EntrepreneurshipService entrepreneurshipService;

    public EventController(EventService service, EntrepreneurshipService entrepreneurshipService) {
        this.service = service;
        this.entrepreneurshipService = entrepreneurshipService;
    }

    @GetMapping
    public ResponseEntity<?> all(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Event event = service.getEventById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id "+ id + " not found"));
        return new ResponseEntity(event, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EventDto dto){
        Event event = EventMapper.mapToModel(dto);
        return new ResponseEntity(service.save(event), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid EventDto eventDto){
        if (id != eventDto.getId()){
            return new ResponseEntity("Data not match", HttpStatus.BAD_REQUEST);
        }
        Event eventDB = service.getEventById(id)
                .orElseThrow(()-> new EntityNotFoundException("Event with id "+ id + " not found"));
        eventDB.setDetails(eventDto.getDetails());
        eventDB.setCloseDate(eventDto.getCloseDate());
        eventDB.setState(eventDto.getState());
        eventDB.setPrize(eventDto.getPrize());

        return new ResponseEntity(service.save(eventDB), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}/newSubscriber/{idSubscriber}")
    public ResponseEntity<?> addSubscriber(@PathVariable Long id, @PathVariable Long idSubscriber){
        Event event = service.getEventById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id "+ id + " not found"));
        Entrepreneurship entrepreneurship = entrepreneurshipService.getEntrepreneurshipById(idSubscriber)
                .orElseThrow(() -> new EntityNotFoundException("Entrepreneurship with id "+ idSubscriber + " not found"));
        entrepreneurship.setEvent(event);
        event.addSubscriber(entrepreneurship);

        return new ResponseEntity(service.save(event), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Event event = service.getEventById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event with id "+ id + " not found"));
        service.delete(event);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
