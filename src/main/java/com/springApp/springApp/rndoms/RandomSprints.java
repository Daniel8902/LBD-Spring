package com.springApp.springApp.rndoms;


import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.repository.SprintRepository;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class RandomSprints {

    public void create(ApplicationContext context, int num) {

        SprintRepository sprintRepository = context.getBean(SprintRepository.class);

        ArrayList<Sprint> sprints = new ArrayList<>();

        for (int i=0; i<num; i++) {
            Random random = new Random();
            int rndYear = random.nextInt(6)+1;
            int rndDay = random.nextInt(7)+1;

            Sprint a = new Sprint();
            a.setName(UUID.randomUUID().toString());
            a.setDescription(UUID.randomUUID().toString());
            a.setStartDate(Timestamp.valueOf("202"+rndYear+"-0"+rndDay     +"-01 00:00:00.0"));
            a.setEndDate(Timestamp.valueOf("202"+rndYear+"-0"+(rndDay+1) +"-01 05:00:00.0"));

            a.setStatus(Arrays.asList(Sprint.StatusType.values()).get(random.nextInt(4)));

            sprints.add(a);
        }
        sprintRepository.saveAll(sprints);
    }

}
