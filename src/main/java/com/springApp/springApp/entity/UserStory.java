package com.springApp.springApp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERSTORY")
public class UserStory {
    @Column(name="id")
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;                                              // https://stackoverflow.com/questions/39807483/sequence-hibernate-sequence-not-found-sql-statement - @GeneratedValue(...)
    @Column(name="name_user")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="number_story_points")
    private Integer number_story_points;
    @Column(name="status")
    private String status;



    @ManyToMany(mappedBy="userStories")
    private List<Sprint> sprints = new ArrayList<>();

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setStory_points_amount(Integer story_points_amount) { this.number_story_points = story_points_amount; }
    public Integer getStory_points_amount() { return number_story_points; }

    public void setStatus(StatusType status) { this.status = status.toString(); }
    public String getStatus() { return status; }


    public enum StatusType {
        TO_DO, IN_PROGRESS, REVIEW, DONE
    }

}
