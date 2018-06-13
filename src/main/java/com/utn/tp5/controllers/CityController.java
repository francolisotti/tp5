package com.utn.tp5.controllers;

import com.utn.tp5.DTO.CityDTO;
<<<<<<< HEAD
<<<<<<< HEAD
import com.utn.tp5.service.CityService;
=======
import com.utn.tp5.Service.CityService;
>>>>>>> parent of 9056e30... Tests
=======
import com.utn.tp5.Service.CityService;
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.model.City;
import com.utn.tp5.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.utn.tp5.Tp5Application.modelmapper;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/", produces = "application/json")
    public List<CityDTO> listCities() {
        List<City> cities = cityService.getAll();
        List<CityDTO> rtn = new ArrayList<>();
        CityDTO dto;
        for (City city : cities){
            dto = modelmapper.map(city,CityDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public CityDTO getCityById (@PathVariable("id") Long id){
        City city = cityService.getById(id);
        CityDTO rtn = modelmapper.map(city,CityDTO.class);
        return rtn;
    }

    @GetMapping(value = "/create")
    public void createCity(String name, String iata, Country country){
        City c = new City (name,iata,country);
        cityService.saveCity(c);
    }

    @DeleteMapping(value = "/delete/{name}")
    public void deleteCity(@PathVariable("name") String name){
        cityService.deleteCity(name);
    }
}
