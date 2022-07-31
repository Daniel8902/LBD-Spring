package com.springApp.springApp.repository;



import com.springApp.springApp.entity.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository

public interface SprintRepository extends PagingAndSortingRepository<Sprint, Long> {
    Optional<Sprint> findByName(String name);

    @Query
            ("SELECT a FROM Sprint a WHERE a.startDate BETWEEN :start AND :end")
    List<Sprint> getBetweenDates(@Param("start") Timestamp start, @Param("end") Timestamp end);


    @Query
            ("SELECT SUM(a.number_story_points) FROM Sprint s JOIN s.userStories a WHERE s.id=:sprintID AND a.status LIKE 'DONE'")
    Integer getNumberStoryPointsById(@Param("sprintID") Long id);




}
