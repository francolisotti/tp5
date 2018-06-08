package com.utn.tp5.Service;

import com.utn.tp5.Persistence.CityPersistence;
import com.utn.tp5.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CityService {

    @Autowired
    CityPersistence cityPersistence;

    public List<City> getAll(){
        return cityPersistence.findAll();
    }

    public City getById(Long id){
        return cityPersistence.getOne(id);
    }

    public void saveCity(City c){
        cityPersistence.save(c);
    }

    public void deleteCity(String name){
        cityPersistence.deleteByName(name);
    }

}
