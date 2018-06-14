package com.utn.tp5.controllers;

import com.utn.tp5.DTO.RouteDTO;

import com.utn.tp5.service.AirportService;
import com.utn.tp5.service.RouteService;
import com.utn.tp5.model.Airport;
import com.utn.tp5.model.Route;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;
    @Autowired
    AirportService airportService;

    @GetMapping(value = "/", produces = "application/json")
    public List<RouteDTO> listRoutes() {
        List<Route> routes = routeService.getAll();
        List<RouteDTO> rtn = new ArrayList<>();
        for (Route route: routes){
            rtn.add(new RouteDTO(route));
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public RouteDTO getRouteById(@PathVariable("id") Long id){
        Route route = routeService.getById(id);
        RouteDTO rtn = new RouteDTO(route);
        return rtn;
    }

    @PostMapping(value = "/create")
    public void createRoute(int distance, Long id_origin, Long id_destination){
        Airport origin = airportService.getById(id_origin);
        Airport destination = airportService.getById(id_destination);
        Route route = new Route (distance, origin, destination);
        routeService.saveRoute(route);
    }

   /* @DeleteMapping(value = "/{id}")
    public void deleteRoute(@PathVariable("name") String name){
        routeService.deleteRoute(name);
    }*/
}
