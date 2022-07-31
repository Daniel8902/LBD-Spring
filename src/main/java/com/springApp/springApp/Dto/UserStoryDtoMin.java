package com.springApp.springApp.Dto;

public class UserStoryDtoMin {
    private String description;

    public UserStoryDtoMin(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserStoryDtoMin(String description) {
        this.description = description;
    }
}
