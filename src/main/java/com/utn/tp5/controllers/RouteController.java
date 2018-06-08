package com.utn.tp5.controllers;

import com.utn.tp5.DTO.CityDTO;
import com.utn.tp5.DTO.RouteDTO;
import com.utn.tp5.Service.AirportService;
import com.utn.tp5.Service.RouteService;
import com.utn.tp5.model.Airport;
import com.utn.tp5.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.utn.tp5.Tp5Application.modelmapper;

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
        RouteDTO dto;
        for (Route route: routes){
            dto = modelmapper.map(route,RouteDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public RouteDTO getRouteById(@PathVariable("id") Long id){
        Route route = routeService.getById(id);
        RouteDTO rtn = modelmapper.map(route,RouteDTO.class);
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
