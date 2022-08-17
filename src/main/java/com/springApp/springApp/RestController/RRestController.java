package com.springApp.springApp.RestController;

import com.springApp.springApp.Convert.ConvertService;
import com.springApp.springApp.Dto.DtoSprint;
import com.springApp.springApp.Dto.Dtoo;
import com.springApp.springApp.Dto.FirstDtoSprint;
import com.springApp.springApp.Dto.UserStoryDtoMin;
import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.SprintRepository;
import com.springApp.springApp.repository.UserStoryRepository;
import com.springApp.springApp.service.NBP;
import com.springApp.springApp.service.SprintService;
import com.springApp.springApp.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class RRestController {
    @Autowired
    SprintService sprintService;
    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    UserStoryRepository usRepository;
    @Autowired
    UserStoryService userStoryService;
    @Autowired
    ConvertService convertService;



    @GetMapping("/hello")
    public String first() {


        return "hello world";


    }

    //////2/////
    @GetMapping("/aless")
    public List<FirstDtoSprint> sprint() {


        return sprintService.listSprints(false);
    }


    ////cz3////
    @PutMapping("/{storyID}/usersstories/{sprintID}")
    Sprint addStoryToSprint(@PathVariable Long storyID, @PathVariable Long sprintID) {
        return sprintService.addUserStory(storyID, sprintID);
    }

    ///4///
    @GetMapping("num/{id}")
    Integer points(@PathVariable Long id) {
        return sprintService.getNumberStoryPointsById(id);
    }

    /////?////
    @GetMapping("/sprintss/{id}")
    DtoSprint findByIddd(@PathVariable Long id) {

        return sprintService.findByIddd(id);

    }

    ////5////
    @GetMapping("users/{id}")
    public List<UserStory> getByIdf(@PathVariable Long id) {

        return sprintService.getById(id);

    }

    ////6////
    @GetMapping("usersId/{id}")
    UserStoryDtoMin findDescription(@PathVariable Long id) {

        return userStoryService.findDescription(id);

    }

    ///////////////////9/////////////
    @PutMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable("id") Long id, @RequestParam Sprint.StatusType statusType) {
        sprintService.updateStatus(id, statusType);
    }

    /////update Sprint////////
    @PutMapping("/des")
    public Sprint sprint(@RequestBody Sprint theSprint) {
        sprintService.saveSprint(theSprint);
        return theSprint;
    }
///////////10//////////
    @GetMapping("/date")
    public List<FirstDtoSprint> betweenDate(@RequestParam(required = false) Timestamp start, @RequestParam(required = false) Timestamp end) {
        List<Sprint> sprintList = sprintService.getBetweenDate(start, end);
        List<FirstDtoSprint> FirstDtoSprint = new ArrayList<>();
        for (Sprint a : sprintList) {
            FirstDtoSprint.add(convertService.convertEntityToDto2(a));
        }
        return FirstDtoSprint;
    }
}

