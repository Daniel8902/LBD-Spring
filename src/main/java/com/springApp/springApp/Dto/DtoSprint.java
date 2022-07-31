package com.springApp.springApp.Dto;


import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DtoSprint {

    private Long id;
    private String name;
//    private Timestamp startDate;
//    private Timestamp endDate;
//    private String description;
//    private String status;
    public DtoSprint(){}

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

    public DtoSprint(Long id, String name) {
        this.id = id;
        this.name = name;
    }
//    public Timestamp getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Timestamp startDate) {
//        this.startDate = startDate;
//    }
//
//    public Timestamp getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Timestamp endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public DtoSprint(Long id, String name, Timestamp startDate, Timestamp endDate, String description, String status) {
//        this.id = id;
//        this.name = name;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.description = description;
//        this.status = status;
//    }
//    private List<UserStory> userStories = new ArrayList<>();
//
//    public List<UserStory> getUserStories() {
//        return userStories;
//    }
//
//    public void setUserStories(List<UserStory> userStories) {
//        this.userStories = userStories;
//    }
//


}

