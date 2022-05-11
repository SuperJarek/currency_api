package com.example.currency.rate;

import com.example.currency.frankfurterApi.FrankfurterApi;
import com.example.currency.frankfurterApi.FrankfurterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;
    @Autowired
    FrankfurterApi frankfurterApi;

    public RateModel createRate(Date date) {
        FrankfurterResponse frankfurterResponse;
        try { // todo wywalic try-catch
            frankfurterResponse = frankfurterApi.getRate(date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rateRepository.save(new RateModel(frankfurterResponse.getRate(), date));
    }

    // READ
    public RateModel getRate(Date date) {
        return rateRepository.findOneByDate(date);
    }

    // DELETE
    public void deleteRate(Long rateId) {
        rateRepository.deleteById(rateId);
    }
}
