package com.springApp.springApp.service;



import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.SprintRepository;
import com.springApp.springApp.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
public class SprintServiceImpl implements SprintService {


    private SprintRepository sprintRepository;

    public SprintServiceImpl(SprintRepository theSprintRepository){
        sprintRepository=theSprintRepository;
    }
    @Autowired
    UserStoryRepository userStoryRepository;





    @Override
    @Transactional
    public void addMoreSprint(String name, Timestamp startDate, Timestamp endDate, String description, Sprint.StatusType status) throws IllegalArgumentException {
        if (!Arrays.asList(Sprint.StatusType.values()).contains(status))
            throw new IllegalArgumentException("wrong Status type");

        if(name.isEmpty()||(startDate.compareTo(endDate)>0)){
            throw new IllegalArgumentException(" wrooong try again");
        }

        Sprint sprint = new Sprint();
        sprint.setName(name);
        sprint.setStartDate(startDate);
        sprint.setEndDate(endDate);
        sprint.setStatus(status);
        if (description != null) sprint.setDescription(description);

        sprintRepository.save(sprint);





    }

    @Override public List<UserStory> getById(Long id) {
        Optional<Sprint> findSprint = sprintRepository.findById(id);
        return findSprint.map(sprint -> new ArrayList<>(sprint.getUserStories())).orElse(null);
    }


    @Override public List<Sprint> getBetweenDate(Timestamp beg, Timestamp end) {
        return sprintRepository.getBetweenDates(beg, end);
    }

    @Override public Integer getNumberStoryPointsById(Long id) {
        Integer points = sprintRepository.getNumberStoryPointsById(id);
        if(points != null) {
            return  points;
        }
        else {
            return 0;
        }
    }

    @Override
    public Page<Sprint> pageSort(Integer page, Integer size) {
        return sprintRepository.findAll(PageRequest.of(page, size,
                Sort.by("startDate")));
    }


    }



