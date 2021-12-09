package com.example.userPoll.repositories;

import com.example.userPoll.model.Question;
import com.example.userPoll.model.QuestionType;
import com.example.userPoll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    boolean existsByPollIdAndTypeAndTextIgnoreCase(Poll poll, QuestionType type, String text);
}