package com.utn.tp5.controllers;

import com.utn.tp5.service.CabinService;
import com.utn.tp5.DTO.RouteXCabinDTO;
import com.utn.tp5.service.PriceService;
import com.utn.tp5.service.RouteService;
import com.utn.tp5.service.RouteXCabinService;
import com.utn.tp5.model.Cabin;
import com.utn.tp5.model.Price;
import com.utn.tp5.model.Route;
import com.utn.tp5.model.RouteXCabin;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteXCabinControllerTest {

    private RouteXCabinController routeXCabinController;
    private RouteXCabinService routeXCabinService;
    private RouteService routeService;
    private CabinService cabinService;
    private PriceService priceService;
    private RouteXCabin routeXCabin;
    private Cabin cabin;
    private Route route;
    private Price price;
    private static ModelMapper modelmapper;

    @Before
    public void contextLoads(){
        this.routeXCabinService = mock(RouteXCabinService.class);
        this.routeService = mock(RouteService.class);
        this.cabinService = mock(CabinService.class);
        this.priceService = mock(PriceService.class);
        this.modelmapper = new ModelMapper();
        this.routeXCabinController = new RouteXCabinController(routeXCabinService,routeService,cabinService,priceService,this.modelmapper);
        this.cabin = mock(Cabin.class);
        this.route = mock(Route.class);
        this.price = mock(Price.class);
        this.routeXCabin = new RouteXCabin(this.cabin,this.route,this.price);
        this.routeXCabin.setId((long)1);
        when(this.routeXCabinService.getById((long)1)).thenReturn(this.routeXCabin);
        when(this.routeXCabinService.saveRouteXCabin(this.routeXCabin)).thenReturn(true);
    }

    @Test
    public void whenRouteXCabinListIsAsked(){
        List<RouteXCabin> routeXCabins = new ArrayList<>();
        routeXCabins.add(this.routeXCabin);
        when(this.routeXCabinService.getAll()).thenReturn(routeXCabins);
        List<RouteXCabinDTO> DTOList = routeXCabinController.listRoutesXCabins();
        for (RouteXCabin routeXCabin : routeXCabins){
            DTOList.add(modelmapper.map(routeXCabin,RouteXCabinDTO.class));
        }
        assertEquals(routeXCabins.get(0).getPrice().getPrice(),DTOList.get(0).getPrice().getPrice());
    }

    @Test
    public void whenARouteXCabinIsAskedById(){
        RouteXCabinDTO a = routeXCabinController.getRouteXCabinById(this.routeXCabin.getId());
        RouteXCabinDTO b = modelmapper.map(this.routeXCabin,RouteXCabinDTO.class);
        assertEquals(a.getPrice().getPrice(),b.getPrice().getPrice());
    }

    @Test
    public void whenARouteXCabinIsAdded(){
    }

    @Test
    public void whenARouteXCabinIsModified(){
        int newPrice = 3210;
        when(this.routeXCabinService.modifyRouteXCabin(this.routeXCabin,newPrice)).thenReturn(true);
        this.routeXCabinController.modifyRouteXCabin(this.routeXCabin.getId(),newPrice);
    }

    @Test
    public void whenARouteXCabinIsDeleted(){

    }
}
