package com.utn.tp5.Service;

<<<<<<< HEAD
import com.utn.tp5.persistence.RouteXCabinPersistence;
import com.utn.tp5.model.Cabin;
import com.utn.tp5.model.Price;
=======
import com.utn.tp5.Persistence.RouteXCabinPersistence;
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.model.RouteXCabin;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteXCabinServiceTest {

    private RouteXCabinService routeXCabinService;
    private RouteXCabin price;
    private RouteXCabinPersistence pricePersistence;

    @Before
    public void contextLoads(){
        this.pricePersistence = mock(RouteXCabinPersistence.class);
        this.routeXCabinService = new RouteXCabinService(pricePersistence);
        this.price = mock(RouteXCabin.class);
    }

    @Test
    public void whenARouteXCabinIsSaved(){
        when(pricePersistence.save(this.price)).thenReturn(this.price);
        Boolean res = this.routeXCabinService.saveRouteXCabin(this.price);
        assertEquals(Boolean.TRUE,res);
    }


    @Test
    public void whenARouteXCabinIsAskedById(){
        when(pricePersistence.getOne(this.price.getId())).thenReturn(this.price);
        RouteXCabin c = this.routeXCabinService.getById(this.price.getId());
        assertEquals(this.price,c);
    }

    @Test
    public void whenTheRouteXCabinListIsAsked(){
        List<RouteXCabin> expected = new ArrayList<>();
        when(pricePersistence.findAll()).thenReturn(expected);
        List<RouteXCabin> prices = this.routeXCabinService.getAll();
        assertEquals(prices,expected);
    }
    /*
    @Test
    public void whenAnRouteXCabinIsModified(){
        //preguntar a saucorp
    }
    */
}
