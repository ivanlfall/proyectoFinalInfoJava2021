package com.ivanlfall.ProyectoFinalInfo2021.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String generatedBy;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
    private LocalDate dischargeDate = LocalDate.now();
    private String observation;

    public Vote() {
    }

    public Vote(String generatedBy, User user, String observation) {
        this.generatedBy = generatedBy;
        this.user = user;
        this.observation = observation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", generatedBy='" + generatedBy + '\'' +
                ", user=" + user +
                ", dischargeDate=" + dischargeDate +
                ", observation='" + observation + '\'' +
                '}';
    }
}
