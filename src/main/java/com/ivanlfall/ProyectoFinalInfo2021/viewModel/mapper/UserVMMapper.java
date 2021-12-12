package com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.UserVM;

public class UserVMMapper {

    public static UserVM mapToModel(User user){
        UserVM userVM = new UserVM();
        userVM.setId(user.getId());
        userVM.setName(user.getName());
        userVM.setLastName(user.getLastName());
        userVM.setEmail(user.getEmail());
        userVM.setPassword(hidePassword(user.getPassword()));
        userVM.setDischargeDate(user.getDischargeDate());
        userVM.setCity(user.getCity());
        userVM.setProvince(user.getProvince());
        userVM.setCountry(user.getCountry());
        userVM.setUserType(user.getUserType());
        userVM.setVote(user.getVote());
        return userVM;
    }

    private static String hidePassword(String pass){
        String hidePass = new String();
        for (int i = 0; i<pass.length(); i++){
            hidePass += "*";
        }
        return hidePass;
    }
}
