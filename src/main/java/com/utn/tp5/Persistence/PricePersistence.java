package com.utn.tp5.Persistence;

import com.utn.tp5.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricePersistence extends JpaRepository<Price,Long> {
}
