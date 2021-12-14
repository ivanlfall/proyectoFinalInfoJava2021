package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.repository.EntrepreneurshipRepository;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.EntrepreneurshipVM;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper.EntrepreneurshipVMMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class EntrepreneurshipService {

    private EntrepreneurshipRepository repository;

    public EntrepreneurshipService(EntrepreneurshipRepository repository) {
        this.repository = repository;
    }

    public List<EntrepreneurshipVM> getAll(){

        return repository.findAll()
                .stream()
                .map(entrepreneurship -> EntrepreneurshipVMMapper.mapToModel(entrepreneurship))
                .collect(Collectors.toList());
    }
    public Optional<Entrepreneurship> getEntrepreneurshipById(Long id){
        return repository.findById(id);
    }
    public List<EntrepreneurshipVM> getAllByTag(String tag){
        return repository.findAll()
                .stream()
                .filter(e -> e.getTags().contains(tag))
                .map(e -> EntrepreneurshipVMMapper.mapToModel(e))
                .collect(Collectors.toList());
    }
    public List<EntrepreneurshipVM> getAllUnpublished(){
        return repository.findAll()
                .stream()
                .filter(e -> !e.isPublished())
                .map(e -> EntrepreneurshipVMMapper.mapToModel(e))
                .collect(Collectors.toList());
    }
    public Entrepreneurship save(Entrepreneurship entrepreneurship){
        return repository.save(entrepreneurship);
    }
    public void delete(Entrepreneurship entrepreneurship){
        repository.delete(entrepreneurship);
    }
}
