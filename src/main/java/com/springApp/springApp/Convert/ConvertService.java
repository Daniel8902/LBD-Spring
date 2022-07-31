package com.springApp.springApp.Convert;

import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.DtoUserstory1;
import com.springApp.springApp.Dto.FirstDtoSprint;
import com.springApp.springApp.Dto.UserStoryDtoMin;
import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    public DtoSprint convertEntityToDto(Sprint entity) {
        DtoSprint sprintDto = new DtoSprint();
        sprintDto.setId(entity.getId());
        sprintDto.setName(entity.getName());
        //   sprintDto.setStartDate(entity.getStartDate());
        // sprintDto.setEndDate(entity.getEndDate());
        //sprintDto.setUserStories(entity.getUserStories());
        // sprintDto.setDescription(entity.getDescription());
        //sprintDto.setStatus(entity.getStatus());
        return sprintDto;
    }

    public DtoUserstory1 convertEntityToDTO(UserStory userStories) {
        DtoUserstory1 storyDto = new DtoUserstory1();
        storyDto.setId(userStories.getId());
        storyDto.setName(userStories.getName());
        storyDto.setNumber_story_points(userStories.getStory_points_amount());


        storyDto.setSprints(userStories.getSprints());

        return storyDto;
    }

    public UserStoryDtoMin convert1EntityToDTO(UserStory userStories) {
        UserStoryDtoMin storyDtomin = new UserStoryDtoMin();
        // storyDtomin.setId(userStories.getId());
        storyDtomin.setDescription(userStories.getDescription());


        return storyDtomin;
    }

    public FirstDtoSprint convertEntityToDto2(Sprint sprint) {

        FirstDtoSprint firstDtoSprint = new FirstDtoSprint();
        firstDtoSprint.setId(sprint.getId());
        firstDtoSprint.setName(sprint.getName());
        firstDtoSprint.setStartDate(sprint.getStartDate());
        firstDtoSprint.setEndDate(sprint.getEndDate());
        firstDtoSprint.setStatus(sprint.getStatus());

        return firstDtoSprint;
    }
}