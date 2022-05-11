package com.example.currency.request;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    RequestService requestService;

    @RequestMapping(value="/requests", method= RequestMethod.GET)
    public List<RequestModel> getRates() {
        return requestService.getRequestsSorted();
    }
}
