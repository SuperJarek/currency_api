package com.example.currency.frankfurterApi;

import com.example.currency.commons.DateFormatProvider;
import com.example.currency.commons.ObjectMapperProvider;
import com.example.currency.commons.RequestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

@Service
public class FrankfurterApi {
    private final static String URL_BASE = "https://api.frankfurter.app/";
    private final static String URL_PARAMS = "?from=EUR&to=USD";

    @Autowired
    DateFormatProvider dateFormatProvider;
    @Autowired
    ObjectMapperProvider objectMapperProvider;
    @Autowired
    RequestProvider requestProvider;


    public FrankfurterResponse getRate(Date date) throws IOException {
        URL url = getUrl(date);
        InputStream inputStream = getReponse(url);
        FrankfurterResponse frankfurterResponse = objectMapperProvider.get().readValue(inputStream, FrankfurterResponse.class);
        inputStream.close();
        return frankfurterResponse;
    }

    private URL getUrl(Date date) throws MalformedURLException {
        String dateString = dateFormatProvider.get().format(date);
        String sURL = URL_BASE + dateString + URL_PARAMS;
        return new URL(sURL);
    }

    private InputStream getReponse(URL url) throws IOException {
        URLConnection request = requestProvider.get(url);
        request.connect();
        return (InputStream) request.getContent();
    }
}
