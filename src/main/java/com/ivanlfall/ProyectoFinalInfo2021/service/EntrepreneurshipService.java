package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.repository.EntrepreneurshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepreneurshipService {

    private EntrepreneurshipRepository repository;

    public EntrepreneurshipService(EntrepreneurshipRepository repository) {
        this.repository = repository;
    }

    public List<Entrepreneurship> getAll(){
        return repository.findAll();
    }
    public Entrepreneurship getEntrepreneurshipById(Long id){
        return repository.findById(id).get();
    }
    public Entrepreneurship save(Entrepreneurship entrepreneurship){
        return repository.save(entrepreneurship);
    }
    public void delete(Entrepreneurship entrepreneurship){
        repository.delete(entrepreneurship);
    }
}
