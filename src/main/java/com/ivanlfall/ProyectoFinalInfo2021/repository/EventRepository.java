package com.ivanlfall.ProyectoFinalInfo2021.repository;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
