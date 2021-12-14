package com.ivanlfall.ProyectoFinalInfo2021.controller;

import com.ivanlfall.ProyectoFinalInfo2021.dto.UserDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.entity.mapper.UserMapper;
import com.ivanlfall.ProyectoFinalInfo2021.service.UserService;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.UserVM;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper.UserVMMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> all(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        User user = service.getUserById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id "+ id + " not found"));
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @GetMapping("/city")
    public ResponseEntity<?> getUsersByCity(@RequestParam(defaultValue = "") String city){
        return new ResponseEntity(service.getAllByCity(city), HttpStatus.OK);
    }
    @GetMapping("/date")
    public ResponseEntity<?> getUsersByDate(@RequestParam(defaultValue = " ")String date){
        LocalDate dateAux;
        if (date.equals(" ")){
            dateAux = null;
        }else{
            dateAux = LocalDate.parse(date);
        }
        return new ResponseEntity(service.getAllCreatedAfterDate(dateAux), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDto dto){
        User user = UserMapper.mapToModel(dto);
        return new ResponseEntity(service.save(user), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDto userDto){
        if (id != userDto.getId()){
           return new ResponseEntity("Data not match", HttpStatus.BAD_REQUEST);
        }
        User userDB = service.getUserById(id)
                .orElseThrow(()-> new EntityNotFoundException("User with id "+ id + " not found"));
        userDB.setName(userDto.getName());
        userDB.setLastName(userDB.getLastName());
        userDB.setEmail(userDto.getEmail());
        userDB.setPassword(userDto.getPassword());
        userDB.setCity(userDto.getCity());
        userDB.setProvince(userDto.getProvince());
        userDB.setCountry(userDto.getCountry());
        userDB.setUserType(userDto.getUserType());

        return new ResponseEntity(service.save(userDB), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        User user = service.getUserById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id "+ id + " not found"));
        service.delete(user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
