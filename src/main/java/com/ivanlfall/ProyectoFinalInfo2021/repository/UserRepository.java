package com.ivanlfall.ProyectoFinalInfo2021.repository;

import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
