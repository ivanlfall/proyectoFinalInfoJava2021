package com.ivanlfall.ProyectoFinalInfo2021.repository;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
