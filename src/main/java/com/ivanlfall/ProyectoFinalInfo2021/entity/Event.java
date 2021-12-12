package com.ivanlfall.ProyectoFinalInfo2021.entity;

import com.ivanlfall.ProyectoFinalInfo2021.util.StateType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String details;
    private LocalDate dischargeDate = LocalDate.now();
    private LocalDate closeDate;
    private StateType state;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrepreneurship> subscribers = new ArrayList<>();
    private Double prize;

    public Event() {
    }

    public Event(String details, StateType state, List<Entrepreneurship> subscribers, Double prize) {
        this.details = details;
        this.state = state;
        this.subscribers = subscribers;
        this.prize = prize;
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

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
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

    public List<Entrepreneurship> getSubscribers() {
        return subscribers;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", dischargeDate=" + dischargeDate +
                ", closeDate=" + closeDate +
                ", state=" + state +
                ", subscribers=" + subscribers +
                ", prize=" + prize +
                '}';
    }
}
