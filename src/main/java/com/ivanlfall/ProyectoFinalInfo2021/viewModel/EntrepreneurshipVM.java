package com.ivanlfall.ProyectoFinalInfo2021.viewModel;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;

import java.time.LocalDate;
import java.util.List;

public class EntrepreneurshipVM {

    private Long id;
    private String name;
    private String description;
    private String content;
    private LocalDate dischargeDate;
    private Double target;
    private List<String> url;
    private List<String> tags;
    private String event;

    public EntrepreneurshipVM() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }


}
