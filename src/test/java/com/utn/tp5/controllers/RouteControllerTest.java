package com.utn.tp5.controllers;

import com.utn.tp5.model.City;
import com.utn.tp5.model.Country;
import com.utn.tp5.service.AirportService;
import com.utn.tp5.DTO.RouteDTO;
import com.utn.tp5.service.RouteService;
import com.utn.tp5.model.Airport;
import com.utn.tp5.model.Route;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RouteControllerTest {

    private RouteController routeController;
    private RouteService routeService;
    private AirportService airportService;
    private Route route;
    private Airport origin;
    private Airport destination;

    @Before
    public void contextLoads(){
        this.routeService = mock(RouteService.class);
        this.airportService = mock(AirportService.class);
        this.routeController = new RouteController(this.routeService,this.airportService);
        this.origin = new Airport("Example","Exa",new City("Example","Exa",new Country("Example","Exa")),1010,0101);
        this.destination = new Airport("Example2","Exa2",new City("Example2","Exa2",new Country("Example2","Exa2")),5050,0505);
        this.route = new Route(1234,this.origin,this.destination);
        this.route.setId((long)1);
        when(this.routeService.getById((long)1)).thenReturn(this.route);
        when(this.routeService.saveRoute(this.route)).thenReturn(true);
    }

    @Test
    public void whenRouteListIsAsked(){
        List<Route> routes = new ArrayList<>();
        routes.add(this.route);
        when(this.routeService.getAll()).thenReturn(routes);
        List<RouteDTO> DTOList = routeController.listRoutes();
        for (Route route : routes){
            DTOList.add(new RouteDTO(route));
        }
        assertEquals(routes.get(0).getDistance(),DTOList.get(0).getDistance(),0.001);
    }

    @Test
    public void whenARouteIsAskedById(){
        RouteDTO a = routeController.getRouteById(this.route.getId());
        RouteDTO b = new RouteDTO(this.route);
        assertEquals(a.getDistance(),b.getDistance(),0.001);
    }

    @Test
    public void whenARouteIsAdded(){
    }

    @Test
    public void whenARouteIsDeleted(){

    }
}
