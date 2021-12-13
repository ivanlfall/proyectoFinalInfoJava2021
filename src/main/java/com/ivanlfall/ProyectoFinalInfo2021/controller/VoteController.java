package com.ivanlfall.ProyectoFinalInfo2021.controller;

import com.ivanlfall.ProyectoFinalInfo2021.dto.VoteDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;
import com.ivanlfall.ProyectoFinalInfo2021.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{entrepreneurshipId}")
    public ResponseEntity<?> create(@PathVariable Long userId, @PathVariable Long entrepreneurshipId, @RequestBody VoteDto voteDto){
        Vote vote = service.generate(userId, entrepreneurshipId, voteDto);
        return new ResponseEntity(vote, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllByUser(@PathVariable Long userId){
        return new ResponseEntity(service.getAllByUser(userId), HttpStatus.OK);
    }
}
