package com.example.currency.rate;

import com.example.currency.FrankfurterApi.FrankfurterApi;
import com.example.currency.commons.DateFormatProvider;
import com.example.currency.request.RequestModel;
import com.example.currency.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RateController {

    @Autowired
    RateService rateService;
    @Autowired
    RequestService requestService;
    @Autowired
    DateFormatProvider dateFormatProvider;

    @RequestMapping(value="/rates/{date}", method= RequestMethod.GET)
    public RateModel createRate(@PathVariable(value="date") String date_string) throws ParseException {
        // todo wyjatek o braku daty
        Date date = dateFormatProvider.get().parse(date_string);

        RateModel rateModel = rateService.getRate(date);
        if (rateModel == null) {
            rateModel = rateService.createRate(date);
        }
        requestService.createRequest(rateModel);
        // todo wyjatek o zlej dacie
        return rateModel;
    }
}
