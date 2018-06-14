package com.utn.tp5.Persistence;

import com.utn.tp5.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePersistence extends JpaRepository<Route,Long> {
}
