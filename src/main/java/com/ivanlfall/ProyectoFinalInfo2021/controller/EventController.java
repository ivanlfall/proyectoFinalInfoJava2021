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
        Event event = service.getEventById(id);
        return new ResponseEntity(event, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EventDto dto){
        Event event = EventMapper.mapToModel(dto);
        return new ResponseEntity(service.save(event), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Event event){
        if (id != event.getId()){
            new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(service.save(event), HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}/newSubscriber/{idSubscriber}")
    public ResponseEntity<?> addSubscriber(@PathVariable Long id, @PathVariable Long idSubscriber){
        Event event = service.getEventById(id);
        Entrepreneurship entrepreneurship = entrepreneurshipService.getEntrepreneurshipById(idSubscriber);
        entrepreneurship.setEvent(event);
        if (event == null || entrepreneurship == null){
            throw new EntityNotFoundException("Event or Entrepreneurship not found");
        }
        event.addSubscriber(entrepreneurship);

        return new ResponseEntity(service.save(event), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Event event = service.getEventById(id);
        service.delete(event);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
