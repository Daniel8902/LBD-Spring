package com.springApp.springApp.repository;


import com.springApp.springApp.entity.UserStory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserStoryRepository extends PagingAndSortingRepository<UserStory, Long> {


}
