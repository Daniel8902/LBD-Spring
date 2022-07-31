package com.springApp.springApp.Dto;

import com.springApp.springApp.entity.Sprint;

import java.sql.Timestamp;
import java.util.List;

public class FirstDtoSprint {
    private Long id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;
    private String status;
    private List<DtoUserstory1> userStories;


    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setStartDate(Timestamp start_date) { this.startDate = start_date; }
    public Timestamp getStartDate() { return startDate; }

    public void setEndDate(Timestamp end_date) { this.endDate = end_date; }
    public Timestamp getEndDate() { return endDate; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

    public List<DtoUserstory1> getUserStories() { return userStories; }
    public void setUserStories(List<DtoUserstory1> userStories) { this.userStories = userStories; }
}
