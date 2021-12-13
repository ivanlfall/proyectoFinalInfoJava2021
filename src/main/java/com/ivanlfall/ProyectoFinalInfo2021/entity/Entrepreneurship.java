package com.ivanlfall.ProyectoFinalInfo2021.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entrepreneurship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String content;
    private LocalDate dischargeDate = LocalDate.now();
    private Double target;
    private boolean published;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> url = new ArrayList<>();
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> tags;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Event event;
//    @OneToMany
//    private List<Vote> votes = new ArrayList<>();

    public Entrepreneurship() {
    }

    public Entrepreneurship(String name, String description, String content, Double target) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.target = target;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Entrepreneurship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", dischargeDate=" + dischargeDate +
                ", target=" + target +
                ", published=" + published +
                ", url=" + url +
                ", tags='" + tags + '\'' +
                '}';
    }
}
