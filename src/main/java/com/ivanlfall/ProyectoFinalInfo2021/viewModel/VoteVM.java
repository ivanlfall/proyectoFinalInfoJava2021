package com.ivanlfall.ProyectoFinalInfo2021.viewModel;


import java.time.LocalDate;

public class VoteVM {
    private Long id;
    private String generatedBy;
    private Long userId;
    private Long entrepreneurshipId;
    private LocalDate dischargeDate;

    public VoteVM() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEntrepreneurshipId() {
        return entrepreneurshipId;
    }

    public void setEntrepreneurshipId(Long entrepreneurshipId) {
        this.entrepreneurshipId = entrepreneurshipId;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
