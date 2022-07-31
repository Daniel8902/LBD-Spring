package com.springApp.springApp.Dto;


import com.springApp.springApp.entity.Sprint;

import java.util.ArrayList;
import java.util.List;

public class DtoUserstory1
{
    private Long id;
    private String name;
    private Integer number_story_points;
    public DtoUserstory1(){}
    private List<Sprint> sprints = new ArrayList<>();

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    public DtoUserstory1(Long id, String name, Integer number_story_points) {
        this.id = id;
        this.name = name;
        this.number_story_points = number_story_points;
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

    public Integer getNumber_story_points() {
        return number_story_points;
    }

    public void setNumber_story_points(Integer number_story_points) {
        this.number_story_points = number_story_points;
    }
}
