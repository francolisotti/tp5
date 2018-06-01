package com.utn.tp5.controllers;

import com.utn.tp5.Service.AirportService;
import com.utn.tp5.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Airport> listAirports() {
       List<Airport> rtn = airportService.getAll();
       return rtn;
    }

}
