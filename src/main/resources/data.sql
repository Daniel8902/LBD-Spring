



INSERT INTO Sprint(name_sprint, start_date, description, status) VALUES ( 'sprintnam1', CURRENT_TIMESTAMP, 'desc miky', 'PENDING' );
SET @sprintKey= (SELECT MAX(id) FROM Sprint);

 INSERT INTO UserStory(name_user, number_story_points, description, status) VALUES ( 'nameuser6', 2, 'desc dog', 'IN_PROGRESS' );
SET @userStoryKey=(SELECT MAX(id) FROM UserStory);
INSERT INTO SPRINT_USER_STORY(sprint_id, user_story_id) VALUES ( @sprintKey, @userStoryKey );

    INSERT INTO Sprint(name_sprint, start_date, description, status) VALUES ( 'sprintnam2', CURRENT_TIMESTAMP, 'desc miky', 'PENDING' );
SET @sprintKey= (SELECT MAX(id) FROM Sprint);
INSERT INTO Sprint(name_sprint, start_date, description, status) VALUES ( 'sprintnam3', CURRENT_TIMESTAMP, 'desc miky', 'PENDING' );
SET @sprintKey= (SELECT MAX(id) FROM Sprint);

INSERT INTO UserStory(name_user, number_story_points, description, status) VALUES ( 'nameuser1', 5, 'des cat', 'DONE' );
SET @userStoryKey=(SELECT MAX(id) FROM UserStory);
INSERT INTO SPRINT_USER_STORY(sprint_id, user_story_id) VALUES ( @sprintKey, @userStoryKey );

INSERT INTO UserStory(name_user,number_story_points, description, status) VALUES ( 'nameuser2', 3,'desc cat', 'TO_DO' );
SET @userStoryKey=(SELECT MAX(id) FROM UserStory);
INSERT INTO SPRINT_USER_STORY(sprint_id, user_story_id) VALUES ( @sprintKey, @userStoryKey );

INSERT INTO UserStory(name_user, description, status) VALUES ( 'nameuser3', 'descmause', 'DONE' );
SET @userStoryKey=(SELECT MAX(id) FROM UserStory);
INSERT INTO SPRINT_USER_STORY(sprint_id, user_story_id) VALUES ( @sprintKey, @userStoryKey );

INSERT INTO UserStory(name_user, number_story_points, description, status) VALUES ( 'nameuser4', 2, 'desc dog', 'IN_PROGRESS' );
SET @userStoryKey=(SELECT MAX(id) FROM UserStory);
INSERT INTO SPRINT_USER_STORY(sprint_id, user_story_id) VALUES ( @sprintKey, @userStoryKey );