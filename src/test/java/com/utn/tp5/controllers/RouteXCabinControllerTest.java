package com.utn.tp5.controllers;

import com.utn.tp5.model.*;
import com.utn.tp5.service.CabinService;
import com.utn.tp5.DTO.RouteXCabinDTO;
import com.utn.tp5.service.PriceService;
import com.utn.tp5.service.RouteService;
import com.utn.tp5.service.RouteXCabinService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
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
    private Airport origin;
    private Airport destination;

    @Before
    public void contextLoads() {
        this.routeXCabinService = mock(RouteXCabinService.class);
        this.routeService = mock(RouteService.class);
        this.cabinService = mock(CabinService.class);
        this.priceService = mock(PriceService.class);
        this.routeXCabinController = new RouteXCabinController(routeXCabinService, routeService, cabinService, priceService);

        this.cabin = new Cabin("Example");

        this.origin = new Airport("Example", "Exa", new City("Example", "Exa", new Country("Example", "Exa")), 1010, 0101);
        this.destination = new Airport("Example2", "Exa2", new City("Example2", "Exa2", new Country("Example2", "Exa2")), 5050, 0505);
        this.route = new Route(1234, this.origin, this.destination);

        this.price = new Price(1234, mock(Date.class));

        this.routeXCabin = new RouteXCabin(this.cabin, this.route, this.price);
        this.routeXCabin.setId((long) 1);
        when(this.routeXCabinService.getById((long) 1)).thenReturn(this.routeXCabin);
        when(this.routeXCabinService.saveRouteXCabin(this.routeXCabin)).thenReturn(true);
    }

    @Test
    public void whenRouteXCabinListIsAsked() {
        List<RouteXCabin> routeXCabins = new ArrayList<>();
        routeXCabins.add(this.routeXCabin);
        when(this.routeXCabinService.getAll()).thenReturn(routeXCabins);
        List<RouteXCabinDTO> DTOList = routeXCabinController.listRoutesXCabins();
        for (RouteXCabin routeXCabin : routeXCabins) {
            DTOList.add(new RouteXCabinDTO(routeXCabin));
        }
        assertEquals(routeXCabins.get(0).getPrice().getPrice(), DTOList.get(0).getPrice().getPrice());
    }

    @Test
    public void whenARouteXCabinIsAskedById() {
        RouteXCabinDTO a = routeXCabinController.getRouteXCabinById(this.routeXCabin.getId());
        RouteXCabinDTO b = new RouteXCabinDTO(this.routeXCabin);
        assertEquals(a.getPrice().getPrice(), b.getPrice().getPrice());
    }

    @Test
    public void whenARouteXCabinIsAdded() {
        /*this.routeXCabinService(this.price);
        verify(this.routeXCabinService)(this.price);*/
    }

    @Test
    public void whenARouteXCabinIsModified() {
        int newPrice = 3210;
        when(this.routeXCabinService.modifyRouteXCabin(this.routeXCabin, newPrice)).thenReturn(true);
        this.routeXCabinController.modifyRouteXCabin(this.routeXCabin.getId(), newPrice);
    }

    /*@Test
    public void whenARouteXCabinIsDeleted() {
        this.routeXCabinController.(this.price);
        verify(this.routeXCabinService).savePrice(this.price);
    }*/
}
