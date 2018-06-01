package com.utn.tp5.Service;


import com.utn.tp5.Persistence.AirportPersistence;
import com.utn.tp5.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    AirportPersistence airportPersistence;

    public List<Airport> getAll(){
        return airportPersistence.findAll();
    }

}
