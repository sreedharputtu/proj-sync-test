package com.ekar.prosynctest.repository;

import com.ekar.prosynctest.entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {

    @Query("select e from Event e")
    public List<Event> findAllEvents();

}
