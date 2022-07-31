package com.springApp.springApp.service;



import com.springApp.springApp.entity.UserStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface UserStoryService {
    UserStory addUser(String name, String description, Integer number_story_points, UserStory.StatusType status) throws IllegalArgumentException;



}
