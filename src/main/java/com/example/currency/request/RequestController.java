package com.example.currency.request;

import com.example.currency.commons.DateFormatProvider;
import com.example.currency.rate.RateModel;
import com.example.currency.rate.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
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
