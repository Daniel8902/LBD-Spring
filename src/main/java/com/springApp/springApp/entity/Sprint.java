package com.springApp.springApp.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Sprint")
public class Sprint {
    @Column(name="id")
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;                                              // https://stackoverflow.com/questions/39807483/sequence-hibernate-sequence-not-found-sql-statement - @GeneratedValue(...)
    @Column(name="name_sprint")
    private String name;
    @Column(name="start_date")
    private Timestamp startDate;
    @Column(name="end_date")
    private Timestamp endDate;
    @Column(name="description")
    private String description;
    @Column(name="status")
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)                                                                                                         // https://www.youtube.com/watch?v=ntN1HWKND8U&ab_channel=CodeForgeYT
    @JoinTable(
            name="SPRINT_USER_STORY",
            joinColumns =@JoinColumn(name="sprint_id"),
            inverseJoinColumns=@JoinColumn(name="user_story_id")
    )
    private List<UserStory> userStories = new ArrayList<>();



    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setStartDate(Timestamp start_date) { this.startDate = start_date; }
    public Timestamp getStartDate() { return startDate; }

    public void setEndDate(Timestamp end_date) { this.endDate = end_date; }
    public Timestamp getEndDate() { return endDate; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setStatus(StatusType status) { this.status = status.toString(); }
    public String getStatus() { return status; }

    public List<UserStory> getUserStories() { return userStories; }
    public void addUserStory(UserStory userStory) { this.userStories.add(userStory); }


    public enum StatusType {
        PENDING, IN_PROGRESS, FINISHED, CANCELED
    }


}
