package com.springApp.springApp.service;



import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.DtoUserstory1;
import com.springApp.springApp.Dto.UserStoryDtoMin;
import com.springApp.springApp.entity.UserStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface UserStoryService {
    UserStory addUser(String name, String description, Integer number_story_points, UserStory.StatusType status) throws IllegalArgumentException;

    UserStoryDtoMin findDescription(Long theId);
    UserStory findByIdUser(Long theId);

}
