package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;
import com.ivanlfall.ProyectoFinalInfo2021.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public List<Vote> getAll(){
        return repository.findAll();
    }
    public Vote getVoteById(Long id){
        return repository.findById(id).get();
    }
    public Vote save(Vote vote){
        return repository.save(vote);
    }
    public void delete(Vote vote){
        repository.delete(vote);
    }
}
