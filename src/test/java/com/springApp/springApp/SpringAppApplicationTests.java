package com.springApp.springApp;

import com.springApp.springApp.entity.Sprint;
import com.springApp.springApp.entity.UserStory;
import com.springApp.springApp.repository.UserStoryRepository;
import com.springApp.springApp.service.SprintService;
import com.springApp.springApp.service.UserStoryService;
import com.springApp.springApp.rndoms.RandomSprints;
import com.springApp.springApp.rndoms.RandomUserStories;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class SpringAppApplicationTests {
	public static final Logger LOG = LoggerFactory.getLogger(SpringBootTest.class);


	@Autowired
	UserStoryRepository userStoryRepository;

	SprintService sprintService;


	UserStoryService userStoryService;

	ApplicationContext context;
	@Autowired
	public SpringAppApplicationTests(SprintService sprintService, UserStoryService userStoryService, ApplicationContext context) {
		this.sprintService = sprintService;
		this.userStoryService = userStoryService;
		this.context = context;
	}



	@Test void addSprint() throws IllegalArgumentException {
		sprintService.addMoreSprint(
				"Dann", Timestamp.valueOf("2022-07-06 00:00:00.0"), Timestamp.valueOf("2024-01-05 00:00:00.0"),
				"description", Sprint.StatusType.PENDING);

	}

	@Test void addUserStory() throws IllegalArgumentException {
		userStoryService.addUser("DAnnn", "DESCRIPTION", 3, UserStory.StatusType.DONE);

	}

	@Test void sprintServiceException() {
		boolean ab = false;

		try {
			sprintService.addMoreSprint(
					"",
					Timestamp.valueOf("2022-07-06 00:00:00.0"), null,
					"descriotion",
					Sprint.StatusType.PENDING);
		} catch (Exception a) {
			LOG.error(a.getMessage());
			ab = true;
		}
		assert ab;
	}




	@Test void sprintByIdGetUserStories() {
		List<UserStory> userStories = sprintService.getById(1L);
		for (UserStory u : userStories)
			System.out.println(u.getId() + "  " + u.getStory_points_amount()+"  "+u.getName() + "  " + u.getStatus());

	}


	@Test void sprintsBetweenDateRange() {
		List<Sprint> num = sprintService.getBetweenDate(Timestamp.valueOf("2022-07-01 00:00:00.0"),
				Timestamp.valueOf("2024-07-07 00:00:00.0")
		);
		System.out.println(sprintService.getBetweenDate(Timestamp.valueOf("2022-07-08 13:29:17.276527"),Timestamp.valueOf("2022-12-31 00:00:00.000000")));
		for (Sprint b : num)
			System.out.println(b.getName() + " "+ b.getStartDate() + "  " + b.getDescription() + "  "+ b.getStatus());

		assert num.size() > 0;
	}


	@Test void getNumberStoryPointsById() {

		System.out.println(sprintService.getNumberStoryPointsById(1L));
	}


	@Test void createRandom() {
		new RandomUserStories().create(context, 100);
	}




	@Test
	public void nextTest(){
		new RandomUserStories().create(context, 100);
		Page<UserStory> userStories =userStoryRepository.findAll(PageRequest.of(0,10));

		for (UserStory u : userStories) {
			System.out.println(u.getId() + " | " + u.getName() + " | " + u.getStatus());
		}
		assert (userStories.getSize()==10);

	}



	@Test void sorting() {
		new RandomSprints().create(context, 100);

		Page<Sprint> sprints = sprintService.pageSort(0, 10);

		System.out.println("id             name                          startDate                            status");
		for (Sprint s : sprints) {
			System.out.println(s.getId() + "  "+  s.getName() +"  "+  s.getStartDate()+"  " + s.getStatus());
		}
	}




}
