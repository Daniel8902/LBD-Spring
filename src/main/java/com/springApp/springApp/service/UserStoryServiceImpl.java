package com.springApp.springApp.service;

import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.UserStoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;


@Service
public class UserStoryServiceImpl implements UserStoryService {

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


}

