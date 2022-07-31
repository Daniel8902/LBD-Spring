

DROP TABLE IF EXISTS SPRINT_USER_STORY;
DROP TABLE IF EXISTS Sprint;
DROP TABLE IF EXISTS UserStory;

CREATE TABLE IF NOT EXISTS Sprint(
    id integer PRIMARY KEY AUTO_INCREMENT,
    name_sprint text NOT NULL,
    start_date timestamp,
    end_date timestamp,
    description text,
         status ENUM('PENDING','IN_PROGRESS','FINISHED','CANCELED') NOT NULL
    );

CREATE TABLE IF NOT EXISTS UserStory(
               id integer PRIMARY KEY AUTO_INCREMENT,
               name_user text NOT NULL,
              description text NOT NULL,
             number_story_points integer,
             status ENUM('TO_DO', 'IN_PROGRESS', 'REVIEW', 'DONE') NOT NULL
    );

CREATE TABLE IF NOT EXISTS SPRINT_USER_STORY(
    sprint_id integer NOT NULL references Sprint(id),
    user_story_id integer NOT NULL references UserStory(id)
    );



