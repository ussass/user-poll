package com.example.userPoll.repositories;

import com.example.userPoll.model.Poll;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    @Query("from Poll s where s.endDate >= now()")
    List<Poll> finAllActivePoll(Pageable pageable);

    boolean existsByNameIgnoreCase(String name);
}
