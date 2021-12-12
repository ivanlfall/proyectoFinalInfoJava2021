package com.ivanlfall.ProyectoFinalInfo2021.entity.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.dto.UserDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.User;

public class UserMapper {
    public static User mapToModel(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCity(dto.getCity());
        user.setProvince(dto.getProvince());
        user.setCountry(dto.getCountry());
        user.setUserType(dto.getUserType());
        return user;
    }
}
