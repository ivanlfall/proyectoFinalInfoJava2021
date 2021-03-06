package com.ivanlfall.ProyectoFinalInfo2021.controller;

import com.ivanlfall.ProyectoFinalInfo2021.dto.EntrepreneurshipDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.entity.mapper.EntrepreneurshipMapper;
import com.ivanlfall.ProyectoFinalInfo2021.service.EntrepreneurshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/ventures")
public class EntrepreneurshipController {

    private final EntrepreneurshipService service;

    public EntrepreneurshipController(EntrepreneurshipService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> all(){

        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Entrepreneurship entrepreneurship = service.getEntrepreneurshipById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrepreneurship with id "+ id + " not found"));;

        return new ResponseEntity(entrepreneurship, HttpStatus.OK);
    }
    @GetMapping("/searchTag")
    public ResponseEntity<?> getByTag(@RequestParam(defaultValue = "") String tag){
        return new ResponseEntity(service.getAllByTag(tag), HttpStatus.OK);
    }
    @GetMapping("/unpublished")
    public ResponseEntity<?> getAllUnpublished(){
        return new ResponseEntity(service.getAllUnpublished(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EntrepreneurshipDto dto){
        Entrepreneurship entrepreneurship = EntrepreneurshipMapper.mapToModel(dto);
        return new ResponseEntity(service.save(entrepreneurship), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EntrepreneurshipDto entrepreneurshipDto){
        if (id != entrepreneurshipDto.getId()){
            return new ResponseEntity("Data not match", HttpStatus.BAD_REQUEST);
        }
        Entrepreneurship entrepreneurshipDB = service.getEntrepreneurshipById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrepreneurship with id "+ id + " not found"));

        entrepreneurshipDB.setName(entrepreneurshipDto.getName());
        entrepreneurshipDB.setDescription(entrepreneurshipDto.getDescription());
        entrepreneurshipDB.setContent(entrepreneurshipDto.getContent());
        entrepreneurshipDB.setTarget(entrepreneurshipDto.getTarget());
        entrepreneurshipDB.setPublished(entrepreneurshipDto.isPublished());
        entrepreneurshipDB.setUrl(entrepreneurshipDto.getUrls());
        entrepreneurshipDB.setTags(entrepreneurshipDto.getTags());

        return new ResponseEntity(service.save(entrepreneurshipDB), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Entrepreneurship entrepreneurship = service.getEntrepreneurshipById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrepreneurship with id "+ id + " not found"));;
        service.delete(entrepreneurship);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
