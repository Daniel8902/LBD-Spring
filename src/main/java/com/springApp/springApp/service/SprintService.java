package com.springApp.springApp.service;


import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.Dtoo;
import com.springApp.springApp.Dto.FirstDtoSprint;
import com.springApp.springApp.Dto.UserStoryDtoMin;
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

    List<Sprint>getAll();

    Sprint findByIdd(Long theId);
    int getUserStoryPoints(Long id);

   ////////////////////////////
    DtoSprint findByIddd(Long theId);




    Sprint addUserStory(Long userId, Long sprintId);
    List<Sprint> findAlle();
    List<FirstDtoSprint>listSprints(Boolean task);

    void saveSprint(Sprint theSprint);
    void updateStatus( Long sprintId,Sprint.StatusType statusType);
}
