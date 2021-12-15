package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.repository.UserRepository;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.UserVM;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper.UserVMMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserVM> getAll(){
        return repository.findAll()
                .stream()
                .map(user -> UserVMMapper.mapToModel(user))
                .collect(Collectors.toList());
    }
    public Optional<User> getUserById(Long id){
        return repository.findById(id);
    }
    public List<UserVM> getAllByCity(String city){
        String regex = ".*"+city.toLowerCase()+".*";
        Pattern pat = Pattern.compile(regex);
        if (city.equals("")){
            return repository.findAll()
                    .stream()
                    .map(user -> UserVMMapper.mapToModel(user))
                    .collect(Collectors.toList());
        }else{
            return repository.findAll()
                    .stream()
                    .filter(user -> pat.matcher(user.getCity().toLowerCase()).matches())
                    .map(user -> UserVMMapper.mapToModel(user))
                    .collect(Collectors.toList());
        }

    }
    public List<UserVM> getAllCreatedAfterDate(LocalDate date){
        return repository.findAll()
                    .stream()
                    .filter(user -> user.getDischargeDate().compareTo(date) > 0)
                    .map(user -> UserVMMapper.mapToModel(user))
                    .collect(Collectors.toList());

    }
    public User save(User user){
        return repository.save(user);
    }
    public void delete(User user){
        repository.delete(user);
    }
}
