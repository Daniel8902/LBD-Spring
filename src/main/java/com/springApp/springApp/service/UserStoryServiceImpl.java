package com.springApp.springApp.service;

import com.springApp.springApp.Convert.ConvertService;
import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.DtoUserstory1;
import com.springApp.springApp.Dto.UserStoryDtoMin;
import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.SprintRepository2;
import com.springApp.springApp.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserStoryServiceImpl implements UserStoryService {
    @Autowired
    ConvertService convertService;
    @Autowired
    SprintRepository2 sprintRepository2;
    UserStoryRepository userStoryRepository;
    public UserStoryServiceImpl(UserStoryRepository userStoryRepository){
        this.userStoryRepository = userStoryRepository;
    }


    @Override
    @Transactional
    public UserStory addUser(String name, String description, Integer number_story_points, UserStory.StatusType status) throws IllegalArgumentException {

        UserStory userStory = new UserStory();
        userStory.setName(name);
        userStory.setDescription(description);
        if (number_story_points != null) userStory.setStory_points_amount(number_story_points);
        userStory.setStatus(UserStory.StatusType.TO_DO);
        if (status != null && Arrays.asList(UserStory.StatusType.values()).contains(status))
            userStory.setStatus(status);
        userStoryRepository.save(userStory);

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException(" Missing  'name' ");
        if (description == null || description.isEmpty())
            throw new IllegalArgumentException(" Missing  'description' ");

        return userStory;
    }
    @Override
    public UserStory findByIdUser(Long theId) {
        Optional<UserStory> result = userStoryRepository.findById(theId);

        UserStory theUserStory = null;

        if (result.isPresent()) {
            theUserStory = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException(" not found User id - " + theId);
        }

        return theUserStory;
    }
    @Override
    public UserStoryDtoMin findDescription(Long theId) {
        return convertService.convert1EntityToDTO(findByIdUser(theId));
    }

}

