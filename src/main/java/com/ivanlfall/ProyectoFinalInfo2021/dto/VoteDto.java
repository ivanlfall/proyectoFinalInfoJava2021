package com.ivanlfall.ProyectoFinalInfo2021.dto;


import javax.validation.constraints.NotBlank;

public class VoteDto {

    @NotBlank
    private String generatedBy;

    public VoteDto() {
    }
    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }
}
