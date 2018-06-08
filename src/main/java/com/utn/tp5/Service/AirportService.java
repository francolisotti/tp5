package com.utn.tp5.Service;


import com.utn.tp5.Persistence.AirportPersistence;
import com.utn.tp5.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportService {

    @Autowired
    AirportPersistence airportPersistence;

    public List<Airport> getAll(){
        return airportPersistence.findAll();
    }

    public Airport getById(Long id){
        return airportPersistence.getOne(id);
    }

    public void saveAirport(Airport a){
        airportPersistence.save(a);
    }

    public void deleteAirport(String name){
        airportPersistence.deleteByName(name);
    }

    public Airport getByIata(String iata){
        return airportPersistence.getByIata(iata);
    }

    public void updateByIata(Airport airport){
        Airport old = airportPersistence.getByIata(airport.getIata());

        old.setName(airport.getName());
        old.setCity(airport.getCity());
        old.setLatitude(airport.getLatitude());
        old.setLongitude(airport.getLongitude());

        airportPersistence.save(old);
    }

}
