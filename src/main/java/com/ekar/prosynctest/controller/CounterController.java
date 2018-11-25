package com.ekar.prosynctest.controller;

import com.ekar.prosynctest.DTO.EventDTO;
import com.ekar.prosynctest.service.CounterService;
import com.ekar.prosynctest.util.Constants;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.InvalidParameterException;
import java.util.List;

@RequestMapping("/counter")
@RestController
public class CounterController {

    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);


    @Autowired
    private CounterService counterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer getCount() {
        return counterService.getCount();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void increaseThreads(@RequestParam("p1") Integer p1, @RequestParam("p2") Integer p2) {
        logger.debug("Request Params : p1=" + p1 + ",p2=" + p2);
        counterService.IncreaseThreads(p1, p2);
    }

    @PostMapping("/{count}")
    @ResponseStatus(HttpStatus.OK)
    public void setCounter(@PathVariable("count") Integer count) {
        logger.debug("Request Params : count=" + count);
        if(count>100 || count<0){
            throw new IllegalArgumentException(Constants.INVALID_COUNT);
        }else{
            counterService.setCount(count);
        }

    }

    @GetMapping("/events")
    public @ResponseBody  List<EventDTO> getAllEvents(){
        return counterService.getAllEvents();
    }


}
