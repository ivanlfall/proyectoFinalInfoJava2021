package com.ivanlfall.ProyectoFinalInfo2021.dto;

import com.ivanlfall.ProyectoFinalInfo2021.util.StateType;
import java.time.LocalDate;


public class EventDto {

    private Long id;
    private String details;
    private LocalDate closeDate;
    private StateType state;
    private Double prize;

    public EventDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
