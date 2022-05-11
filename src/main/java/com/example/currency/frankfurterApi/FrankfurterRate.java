package com.example.currency.frankfurterApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrankfurterRate {
    @JsonProperty("USD")
    public float value;

    public float getValue() {
        return value;
    }
}
