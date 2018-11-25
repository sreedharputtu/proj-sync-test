package com.ekar.prosynctest.util;

import com.ekar.prosynctest.entity.Event;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class EventBuilder {

    public static Event build(String evenType, Integer val1, Integer val2,String requestor){
        Event e = new Event();
        e.setEventType(evenType);
        e.setCreatedDate(new Date());
        if(val1!=null)
            e.setVal1(val1);
        if(val2!=null)
            e.setVal2(val2);
        e.setRequestor(requestor);
        return e;
    }
}
