package com.utn.tp5.controllers;

import com.utn.tp5.DTO.RouteXCabinDTO;
import com.utn.tp5.CabinService;
import com.utn.tp5.PriceService;
import com.utn.tp5.RouteService;
import com.utn.tp5.RouteXCabinService;
import com.utn.tp5.model.Cabin;
import com.utn.tp5.model.Price;
import com.utn.tp5.model.Route;
import com.utn.tp5.model.RouteXCabin;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/routeXCabin")
public class RouteXCabinController {

    @Autowired
    RouteXCabinService routeXCabinService;
    @Autowired
    RouteService routeService;
    @Autowired
    CabinService cabinService;
    @Autowired
    PriceService priceService;
    ModelMapper modelmapper;

    @GetMapping(value = "/", produces = "application/json")
    public List<RouteXCabinDTO> listRoutesXCabins() {
        List<RouteXCabin> routeXCabins = routeXCabinService.getAll();
        List<RouteXCabinDTO> rtn = new ArrayList<>();
        RouteXCabinDTO dto;
        for (RouteXCabin routeXCabin : routeXCabins){
            dto = modelmapper.map(routeXCabin,RouteXCabinDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public RouteXCabinDTO getRouteXCabinById(@PathVariable("id") Long id){
        RouteXCabin routeXCabin = routeXCabinService.getById(id);
        RouteXCabinDTO rtn = modelmapper.map(routeXCabin,RouteXCabinDTO.class);
        return rtn;
    }

    @PostMapping(value = "/create")
    public void createRouteXCabin(Long id_cabin, Long id_route, Long id_price){
        Cabin cabin = cabinService.getById(id_cabin);
        Route route = routeService.getById(id_route);
        Price price = priceService.getById(id_price);

        RouteXCabin routeXCabin = new RouteXCabin(cabin,route,price);
        routeXCabinService.saveRouteXCabin(routeXCabin);
    }

    @PutMapping(value = "/modify")
    public void modifyRouteXCabin(Long id_routeXCabin, int newPrice){
        RouteXCabin routeXCabin = routeXCabinService.getById(id_routeXCabin);
        routeXCabinService.modifyRouteXCabin(routeXCabin, newPrice);
    }
}
