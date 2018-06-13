package com.utn.tp5.controllers;

import com.utn.tp5.DTO.AirportDTO;
<<<<<<< HEAD
import com.utn.tp5.service.AirportService;
import com.utn.tp5.service.CityService;
=======
import com.utn.tp5.Service.AirportService;
import com.utn.tp5.Service.CityService;
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.model.Airport;
import com.utn.tp5.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.utn.tp5.Tp5Application.modelmapper;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;
    @Autowired
    CityService cityService;

    @GetMapping(value = "/", produces = "application/json")
    public List<AirportDTO> listAirports() {
       List<Airport> airports = airportService.getAll();
       List<AirportDTO> rtn = new ArrayList<>();
       AirportDTO dto;
       for (Airport airport : airports){
           dto = modelmapper.map(airport,AirportDTO.class);
           rtn.add(dto);
       }
       return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public AirportDTO getAirportById(@PathVariable("id") Long id){
        Airport airport = airportService.getById(id);
        AirportDTO rtn = modelmapper.map(airport,AirportDTO.class);
        return rtn;
    }

    @PostMapping(value = "/create")
    public void createAirport(String name, String iata, Long id_city, float latitude, float longitude){
        City city = cityService.getById(id_city);
        Airport a = new Airport (name,iata,city,latitude,longitude);
        airportService.saveAirport(a);
    }

    @PutMapping(value = "/modify")
    public void modifyById(@RequestBody Airport airport){
        airportService.updateByIata(airport);
    }

    @DeleteMapping(value = "/delete/{name}")
    public void deleteAirport(@PathVariable("name") String name){
        airportService.deleteAirport(name);
    }

}
