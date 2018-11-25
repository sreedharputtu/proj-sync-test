package com.ekar.prosynctest.util;

import com.ekar.prosynctest.DTO.EventDTO;
import com.ekar.prosynctest.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDTOBuilder {

    public static EventDTO buildEventDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventId(event.getId());
        eventDTO.setEventType(event.getEventType());
        eventDTO.setEventDate(event.getCreatedDate().toString());
        eventDTO.setVal1(event.getVal1());
        eventDTO.setVal2(event.getVal2());
        eventDTO.setRequestor(event.getRequestor());
        return eventDTO;
    }

    public static List<EventDTO> buildEventDTOList(List<Event> events){
        List<EventDTO> eventDTOS = null;
        if(events!=null && events.size()>0){
          eventDTOS  = new ArrayList<>();
          for(Event  event : events){
              eventDTOS.add(buildEventDTO(event));
          }
        }
        return eventDTOS;
    }
}
