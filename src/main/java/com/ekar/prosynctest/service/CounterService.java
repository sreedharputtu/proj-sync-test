package com.ekar.prosynctest.service;

import com.ekar.prosynctest.DTO.EventDTO;
import com.ekar.prosynctest.controller.CounterController;
import com.ekar.prosynctest.repository.EventRepository;
import com.ekar.prosynctest.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Service
public class CounterService {

    private static final Logger logger = LoggerFactory.getLogger(CounterService.class);

    @Autowired
    private Counter counter;

    @Autowired
    private EventRepository eventDao;

    @PostConstruct
    public void init() {
        startIncrementors(Constants.INIT_NO_OF_THREADS);
        startDecrementors(Constants.INIT_NO_OF_THREADS);
    }

    public Integer getCount() {
        return counter.getCount();
    }

    public List<EventDTO> getAllEvents() {
        return EventDTOBuilder.buildEventDTOList(eventDao.findAllEvents());
    }

    public void setCount(Integer newCount) {
        counter.setCount(newCount);
        eventDao.save(EventBuilder.build(Constants.SET_COUNT_EVENT, newCount, null, Thread.currentThread().getName()));
    }

    public void IncreaseThreads(int noOfIncrementors, int noOfDecrementors) {
        startIncrementors(noOfIncrementors);
        startDecrementors(noOfDecrementors);
        eventDao.save(EventBuilder.build(Constants.INCREASE_THREADS_EVENT, noOfIncrementors, noOfDecrementors, Thread.currentThread().getName()));
    }


    private void startIncrementors(int n) {
        IntStream.range(0, n).forEach(i -> {
            new Incrementor(counter).start();
        });
    }

    private void startDecrementors(int n) {
        IntStream.range(0, n).forEach(i -> {
            new Decrementor(counter).start();
        });
    }

}
