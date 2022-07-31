package com.springApp.springApp.rndoms;



import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.UserStoryRepository;
import org.springframework.context.ApplicationContext;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class RandomUserStories {

    public void create(ApplicationContext context, int num) {

        UserStoryRepository userStoryRepository = context.getBean(UserStoryRepository.class);

        ArrayList<UserStory> userStories = new ArrayList<>();
        for (int i=0;  i<num;  i++) {
            Random accidental = new Random();
            UserStory u = new UserStory();
            u.setName(UUID.randomUUID().toString());
            u.setDescription(UUID.randomUUID().toString());
            u.setStory_points_amount(accidental.nextInt(8));
            u.setStatus(Arrays.asList(UserStory.StatusType.values()).get(accidental.nextInt(4)));
            userStories.add(u);
        }
        userStoryRepository.saveAll(userStories);
    }

}
