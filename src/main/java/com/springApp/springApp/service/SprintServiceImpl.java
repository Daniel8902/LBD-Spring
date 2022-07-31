package com.springApp.springApp.service;



import com.springApp.springApp.Convert.ConvertService;
import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.Dtoo;
import com.springApp.springApp.Dto.FirstDtoSprint;
import com.springApp.springApp.Dto.UserStoryDtoMin;
import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.SprintRepository;
import com.springApp.springApp.repository.SprintRepository2;
import com.springApp.springApp.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    ConvertService convertService;
    private SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository theSprintRepository) {
        sprintRepository = theSprintRepository;
    }

    @Autowired
    UserStoryRepository userStoryRepository;
    @Autowired
    UserStoryService userStoryService;
    @Autowired
    SprintRepository2 sprintRepository2;

    public SprintServiceImpl() {
    }

    @Override
    @Transactional
    // https://www.baeldung.com/transaction-configuration-with-jpa-and-spring - @Transactional pozwala na rollback po jakimkolwiek runtime exception
    public void addMoreSprint(String name, Timestamp startDate, Timestamp endDate, String description, Sprint.StatusType status) throws IllegalArgumentException {
        if (!Arrays.asList(Sprint.StatusType.values()).contains(status))
            throw new IllegalArgumentException("wrong Status type");

        if (name.isEmpty() || (startDate.compareTo(endDate) > 0)) {
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

    @Override
    public List<UserStory> getById(Long id) {
        Optional<Sprint> findSprint = sprintRepository.findById(id);

        return findSprint.map(sprint -> new ArrayList<>(sprint.getUserStories())).orElse(null);
    }


    @Override
    public List<Sprint> getBetweenDate(Timestamp beg, Timestamp end) {
        return sprintRepository.getBetweenDates(beg, end);
    }

    @Override
    public Integer getNumberStoryPointsById(Long id) {
        Integer points = sprintRepository.getNumberStoryPointsById(id);
        if (points != null) {
            return points;
        } else {
            return 0;
        }
    }

    @Override
    public Page<Sprint> pageSort(Integer page, Integer size) {
        return sprintRepository.findAll(PageRequest.of(page, size,
                Sort.by("startDate")));
    }





    @Override
    public Sprint findByIdd(Long theId) {
        Optional<Sprint> result = sprintRepository.findById(theId);

        Sprint theSprint = null;

        if (result.isPresent()) {
            theSprint = result.get();
        } else {

            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theSprint;
    }

    @Override
    public int getUserStoryPoints(Long id) {
        return 0;
    }

    public List<Sprint> getAll() {

        return (List<Sprint>) sprintRepository.findAll();
    }


///////////////////////////////
    @Override
    public DtoSprint findByIddd(Long theId) {
     return convertService.convertEntityToDto(findByIdd(theId));

    }


    @Override
    public List<FirstDtoSprint>listSprints(Boolean task){
        List<Sprint>ListSprint= (List<Sprint>) findAlle();
        return  ListSprint.stream().map(sprint -> {
            FirstDtoSprint firstDtoSprint = convertService.convertEntityToDto2(sprint);
            if (task) {
                firstDtoSprint.setUserStories(sprint.getUserStories().stream().map(userStory -> {
                    return convertService.convertEntityToDTO(userStory);
                }).collect(Collectors.toList()));

            }
            return firstDtoSprint;
        }).collect(Collectors.toList());
    }


    public DtoSprint findAll(){
           List<Sprint>theEmployee = (List<Sprint>) sprintRepository.findAll();
        DtoSprint tt = new DtoSprint();
        tt.setId(theEmployee.iterator().next().getId());
        tt.setName(theEmployee.iterator().next().getName());
        System.out.println(tt);
        return tt;

    }
    @Override
       public List<Sprint> findAlle() {
            return (List<Sprint>) sprintRepository.findAll();
        }



    @Override
    public Sprint addUserStory(Long userId, Long sprintId){
        UserStory userStory=userStoryRepository.findById(userId).get();
        Sprint sprint=sprintRepository.findById(sprintId).get();
        sprint.addUserStory(userStory);
        return sprintRepository.save(sprint);
    }



    @Override
public void saveSprint(Sprint theSprint) {
       sprintRepository2.save(theSprint);

}
@Override
@Transactional
    public void updateStatus( Long id,Sprint.StatusType statusType){
        Sprint sprint=sprintRepository.findById(id).get();
        sprint.setStatus(statusType);


    }

}



