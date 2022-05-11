package com.example.currency.rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RateRepository extends JpaRepository<RateModel, Long> {
    RateModel findOneByDate(Date date);
}