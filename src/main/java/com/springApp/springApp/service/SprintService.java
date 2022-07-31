package com.springApp.springApp.service;


import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.util.List;

public interface SprintService {
    void addMoreSprint(String name, Timestamp start_date, Timestamp end_date, String description, Sprint.StatusType status) throws IllegalArgumentException;
    List<UserStory> getById(Long id);

    List<Sprint> getBetweenDate(Timestamp start_range, Timestamp end_range);
    Integer getNumberStoryPointsById(Long id);
    Page<Sprint> pageSort(Integer page, Integer size);


}
