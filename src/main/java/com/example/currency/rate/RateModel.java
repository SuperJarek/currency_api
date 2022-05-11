package com.example.currency.rate;

import com.example.currency.FrankfurterApi.FrankfurterRate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="rate")
@NoArgsConstructor
public class RateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private long id;

    @Column(name="value")
    private float value;

    @Column(name="date")
    private Date date;

    RateModel(FrankfurterRate frankfurterRate, java.util.Date utilDate) {
        Date sqlDate = new Date(utilDate.getTime());
        this.value = frankfurterRate.getValue();
        this.date = sqlDate;
    }

    public long getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
