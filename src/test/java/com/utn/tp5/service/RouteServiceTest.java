package com.utn.tp5.service;

import com.utn.tp5.persistence.RoutePersistence;
import com.utn.tp5.model.Route;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteServiceTest {

    private RouteService routeService;
    private Route route;
    private RoutePersistence routePersistence;

    @Before
    public void contextLoads() {
        this.routePersistence = mock(RoutePersistence.class);
        this.routeService = new RouteService(routePersistence);
        this.route = mock(Route.class);
    }

    @Test
    public void whenARouteIsSaved() {
        when(routePersistence.save(this.route)).thenReturn(this.route);
        Boolean res = this.routeService.saveRoute(this.route);
        assertEquals(Boolean.TRUE, res);
    }


    @Test
    public void whenARouteIsAskedById() {
        when(routePersistence.getOne(this.route.getId())).thenReturn(this.route);
        Route c = this.routeService.getById(this.route.getId());
        assertEquals(this.route, c);
    }

    @Test
    public void whenTheRouteListIsAsked() {
        List<Route> expected = new ArrayList<>();
        when(routePersistence.findAll()).thenReturn(expected);
        List<Route> routes = this.routeService.getAll();
        assertEquals(routes, expected);
    }
}
