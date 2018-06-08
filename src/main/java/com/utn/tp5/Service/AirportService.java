package com.utn.tp5.Service;


import com.utn.tp5.Persistence.AirportPersistence;
import com.utn.tp5.model.Airport;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AirportService {

    @Autowired
    AirportPersistence airportPersistence;

    public List<Airport> getAll(){
        return airportPersistence.findAll();
    }

    public Airport getById(Long id){
        return airportPersistence.getOne(id);
    }

    public Boolean saveAirport(Airport a){
        Airport saved = airportPersistence.save(a);
        boolean rtn = false;
        if (saved.equals(a)){
            rtn=true;
        }
        return rtn;
    }

    public boolean deleteAirport(String name){
        return airportPersistence.deleteByName(name);
    }
    public Airport updateByIata(Airport airport){
        Airport old = airportPersistence.getByIata(airport.getIata());

        old.setName(airport.getName());
        old.setCity(airport.getCity());
        old.setLatitude(airport.getLatitude());
        old.setLongitude(airport.getLongitude());

        return airportPersistence.save(old);
    }

}
