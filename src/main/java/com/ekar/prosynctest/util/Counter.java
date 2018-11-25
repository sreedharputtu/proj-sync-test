package com.ekar.prosynctest.util;

import com.ekar.prosynctest.repository.EventRepository;
import com.ekar.prosynctest.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {

    private static final Logger logger = LoggerFactory.getLogger(Counter.class);

    private AtomicInteger count = new AtomicInteger(50);

    @Autowired
    private EventRepository eventDao;

    public Integer getCount() {
        return count.get();
    }

    public void setCount(Integer newCount) {
        count.set(newCount);
    }

    public void Increase() {
        int current = count.get();
        if (current < Constants.MAX_COUNT) {
            int next = current + 1;
            logger.debug(Thread.currentThread().getName()+": increased count val = "+next);
            count.compareAndSet(current, next);
            if (next == Constants.MAX_COUNT) {
                eventDao.save(EventBuilder.build(Constants.MAX_LIMIT_EVENT,null,null,Thread.currentThread().getName()));
                logger.debug(Thread.currentThread().getName()+": count  val reached max limit : "+next);

            }
        }
    }

    public void decrease() {
        int current = count.get();
        if (current > Constants.MIN_COUNT) {
            int next = current - 1;
            logger.debug(Thread.currentThread().getName()+": decreased count val = "+next);
            count.compareAndSet(current, next);
            if (next == Constants.MIN_COUNT) {
                eventDao.save(EventBuilder.build(Constants.MIN_LIMIT_EVENT,null,null,Thread.currentThread().getName()));
                logger.debug(Thread.currentThread().getName()+": count  val reached min limit : "+next);
            }
        }
    }

}
