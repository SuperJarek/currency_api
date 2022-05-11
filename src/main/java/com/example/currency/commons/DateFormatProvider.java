package com.example.currency.commons;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class DateFormatProvider {

    private final DateFormat dateFormat;

    public DateFormatProvider() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    public DateFormat get() {
        return dateFormat;
    }
}
