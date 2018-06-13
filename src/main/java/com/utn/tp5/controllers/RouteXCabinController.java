package com.utn.tp5.controllers;

import com.utn.tp5.DTO.RouteXCabinDTO;
<<<<<<< HEAD
<<<<<<< HEAD
import com.utn.tp5.service.CabinService;
import com.utn.tp5.service.PriceService;
import com.utn.tp5.service.RouteService;
import com.utn.tp5.service.RouteXCabinService;
=======
=======
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.Service.CabinService;
import com.utn.tp5.Service.PriceService;
import com.utn.tp5.Service.RouteService;
import com.utn.tp5.Service.RouteXCabinService;
<<<<<<< HEAD
>>>>>>> parent of 9056e30... Tests
=======
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.model.Cabin;
import com.utn.tp5.model.Price;
import com.utn.tp5.model.Route;
import com.utn.tp5.model.RouteXCabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
@AllArgsConstructor @RestController @RequestMapping("/routeXCabin")
=======
=======
>>>>>>> parent of 9056e30... Tests
import static com.utn.tp5.Tp5Application.modelmapper;

@RestController
@RequestMapping("/routeXCabin")
>>>>>>> parent of 9056e30... Tests
public class RouteXCabinController {

    @Autowired
    RouteXCabinService routeXCabinService;
    @Autowired
    RouteService routeService;
    @Autowired
    CabinService cabinService;
    @Autowired
    PriceService priceService;

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

    /*@PutMapping(value = "/modify")
    public void modifyRouteXCabin(Long id_cabin, Long id_route, int newPrice){
        RouteXCabin routeXCabin = routeXCabinService.modifyRouteXCabin(id_cabin, id_route);
        routeXCabin.getPrice().setPrice(newPrice);
        routeXCabinService.saveRouteXCabin(routeXCabin);
    }*/
}
