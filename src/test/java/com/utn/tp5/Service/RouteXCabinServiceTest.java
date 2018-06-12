package com.utn.tp5.service;

import com.utn.tp5.persistence.RouteXCabinPersistence;
import com.utn.tp5.model.Cabin;
import com.utn.tp5.model.Price;
import com.utn.tp5.model.RouteXCabin;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteXCabinServiceTest {

    private RouteXCabinService routeXCabinService;
    private RouteXCabin routeXCabin;
    private Price price;
    private RouteXCabinPersistence routeXCabinPersistence;

    @Before
    public void contextLoads(){
        this.routeXCabinPersistence = mock(RouteXCabinPersistence.class);
        this.routeXCabinService = new RouteXCabinService(routeXCabinPersistence);
        this.routeXCabin = mock(RouteXCabin.class);
        this.price = mock(Price.class);
        this.routeXCabin.setPrice(this.price);
        this.routeXCabin.setCabin(mock(Cabin.class));
        when(routeXCabinPersistence.save(this.routeXCabin)).thenReturn(this.routeXCabin);
    }

    @Test
    public void whenARouteXCabinIsSaved(){
        Boolean res = this.routeXCabinService.saveRouteXCabin(this.routeXCabin);
        assertEquals(Boolean.TRUE,res);
    }


    @Test
    public void whenARouteXCabinIsAskedById(){
        when(routeXCabinPersistence.getOne(this.routeXCabin.getId())).thenReturn(this.routeXCabin);
        RouteXCabin c = this.routeXCabinService.getById(this.routeXCabin.getId());
        assertEquals(this.routeXCabin,c);
    }

    @Test
    public void whenTheRouteXCabinListIsAsked(){
        List<RouteXCabin> expected = new ArrayList<>();
        when(routeXCabinPersistence.findAll()).thenReturn(expected);
        List<RouteXCabin> routeXCabins = this.routeXCabinService.getAll();
        assertEquals(routeXCabins,expected);
    }

    @Test
    public void whenAnRouteXCabinIsModified(){
        when(this.routeXCabin.getPrice()).thenReturn(this.price);
        assertTrue(this.routeXCabinService.modifyRouteXCabin(this.routeXCabin,38456));
    }

}
