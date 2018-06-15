package com.utn.tp5.persistence;

import com.utn.tp5.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PricePersistence extends JpaRepository<Price, Long> {
    Price findByDateFrom(Date dateFrom);
}
