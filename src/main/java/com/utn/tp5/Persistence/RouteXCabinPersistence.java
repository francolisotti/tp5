package com.utn.tp5.persistence;

import com.utn.tp5.model.RouteXCabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteXCabinPersistence extends JpaRepository<RouteXCabin,Long> {
    RouteXCabin getByRouteIdAndAndCabinId(Long RouteId, Long CabinId);
}
