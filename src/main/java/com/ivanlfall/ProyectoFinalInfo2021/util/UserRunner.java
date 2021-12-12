package com.ivanlfall.ProyectoFinalInfo2021.util;

import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
/*        User user = repository.findById(Long.valueOf(1)).get();
        user.setName("Rocio");
        user.setLastName("Carballo");
        user.setEmail("rocarballo@gmail.com");
        user.setUserType(UserType.OWNER);

        user.setUserType(UserType.USER);

        repository.save(user);*/
    }
}
