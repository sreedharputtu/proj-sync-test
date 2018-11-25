package com.ekar.prosynctest.DTO;

import javax.persistence.criteria.CriteriaBuilder;

public class EventDTO {

    private Long eventId;

    private String eventType;

    private String eventDate;

    private Integer val1;

    private Integer val2;

    private String requestor;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getVal1() {
        return val1;
    }

    public void setVal1(Integer val1) {
        this.val1 = val1;
    }

    public Integer getVal2() {
        return val2;
    }

    public void setVal2(Integer val2) {
        this.val2 = val2;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }
}
