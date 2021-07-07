package org.example.repository;


import org.example.domain.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {
    @Query("from Meeting")
    public List<Meeting> findAll();
}
