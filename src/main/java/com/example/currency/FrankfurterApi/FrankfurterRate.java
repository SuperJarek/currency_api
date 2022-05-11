package com.example.currency.FrankfurterApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrankfurterRate {
    @JsonProperty("USD")
    public float value;

    public float getValue() {
        return value;
    }
}
