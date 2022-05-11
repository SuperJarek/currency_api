package com.example.currency.FrankfurterApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrankfurterResponse {
    @JsonProperty("rates")
    public FrankfurterRate rate;

    public FrankfurterRate getRate() {
        return rate;
    }
}
