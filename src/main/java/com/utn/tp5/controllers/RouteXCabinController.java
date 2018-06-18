package com.utn.tp5.controllers;

import com.utn.tp5.DTO.RouteXCabinDTO;
import com.utn.tp5.model.*;
import com.utn.tp5.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/routeXCabin")
public class RouteXCabinController {

    @Autowired
    private RouteXCabinService routeXCabinService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private CabinService cabinService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private AirportService airportService;

    @GetMapping(value = "/", produces = "application/json")
    public List<RouteXCabinDTO> listRoutesXCabins() {
        List<RouteXCabin> routeXCabins = routeXCabinService.getAll();
        List<RouteXCabinDTO> rtn = new ArrayList<>();
        for (RouteXCabin routeXCabin : routeXCabins) {
            rtn.add(new RouteXCabinDTO(routeXCabin));
        }
        return rtn;
    }

    /*@GetMapping(value = "/{id}", produces = "application/json")
    public RouteXCabinDTO getRouteXCabinById(@PathVariable("id")Long id) {
        RouteXCabin routeXCabin = routeXCabinService.getById(id);
        RouteXCabinDTO rtn = new RouteXCabinDTO(routeXCabin);
        return rtn;
    }*/

    @GetMapping(value = "/{iataOrigin}/{iataDestination}", produces = "application/json")
    public List<RouteXCabinDTO> getRouteByOriginAndDestination(@PathVariable("iataOrigin") String iataOrigin, @PathVariable("iataDestination")String iataDestination) {
        Airport origin = airportService.getByIata(iataOrigin);
        Airport destination = airportService.getByIata(iataDestination);
        Route route = routeService.getByOriginAndDestination(origin, destination);

        List<RouteXCabinDTO> rtn = new ArrayList<>();
        List<RouteXCabin> routesXcabins = routeXCabinService.getByRoute(route);
        for (RouteXCabin routeXCabin: routesXcabins) {
            rtn.add(new RouteXCabinDTO(routeXCabin));
        }
        return rtn;
    }



    @PostMapping(value = "/create")
    public void createRouteXCabin(Long id_cabin, Long id_route, Long id_price) {
        Cabin cabin = cabinService.getById(id_cabin);
        Route route = routeService.getById(id_route);
        Price price = priceService.getById(id_price);

        RouteXCabin routeXCabin = new RouteXCabin(cabin, route, price);
        routeXCabinService.saveRouteXCabin(routeXCabin);
    }

    @PutMapping(value = "/modify")
    public void modifyRouteXCabin(Long id_routeXCabin, int newPrice) {
        RouteXCabin routeXCabin = routeXCabinService.getById(id_routeXCabin);
        routeXCabinService.modifyRouteXCabin(routeXCabin, newPrice);
    }
}
