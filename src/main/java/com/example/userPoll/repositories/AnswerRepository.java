package com.example.userPoll.repositories;

import com.example.userPoll.model.Answer;
import com.example.userPoll.model.Question;
import com.example.userPoll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "from Answer a where a.userId = ?1")
    List<Answer> finAllByUserId(long id);

    @Transactional
    List<Answer> deleteByQuestionId(Question question);

    @Transactional
    List<Answer> deleteByPollId(Poll poll);
}
