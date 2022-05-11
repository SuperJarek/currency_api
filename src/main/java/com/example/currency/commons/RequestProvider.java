package com.example.currency.commons;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class RequestProvider {

    public URLConnection get(URL url) throws IOException {
        return url.openConnection();
    }
}
