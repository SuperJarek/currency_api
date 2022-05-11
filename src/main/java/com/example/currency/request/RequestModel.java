package com.example.currency.request;

import com.example.currency.rate.RateModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="request")
@NoArgsConstructor
public class RequestModel {
    RequestModel(RateModel rateModel) {
        timestamp = new Date();
        this.rateModel = rateModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private int id;

    @Column(name="timestamp")
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    @JsonProperty("rate")
    private RateModel rateModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public RateModel getRateModel() {
        return rateModel;
    }

    public void setRateModel(RateModel rateModel) {
        this.rateModel = rateModel;
    }
}
