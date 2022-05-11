package com.example.currency.request;

import com.example.currency.rate.RateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public void createRequest(RateModel rateModel) {
        RequestModel requestModel = new RequestModel(rateModel);
        requestRepository.save(requestModel);
    }
    public List<RequestModel> getRequestsSorted() {
        return requestRepository.findAll(Sort.by("timestamp"));
    }

}

