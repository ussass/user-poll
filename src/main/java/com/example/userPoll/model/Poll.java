package com.example.userPoll.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @JsonIgnore
    @Column(name = "start_Date")
    private final long startDate = new Date().getTime();

    @JsonIgnore
    @Column(name = "end_Date")
    private long endDate;

    @JsonProperty(value = "questions")
    @OneToMany(mappedBy = "pollId", cascade = CascadeType.ALL)
    private List<Question> questionList;

    public Poll() {
    }

    public Poll(String name, String description, long endDate) {
        this.name = name;
        this.description = description;
        this.endDate = endDate;
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    public LocalDateTime getStart_date() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(startDate), ZoneId.systemDefault());
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    public LocalDateTime getEnd_date() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(endDate), ZoneId.systemDefault());
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
