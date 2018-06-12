package com.utn.tp5.service;

import com.utn.tp5.AirportService;
import com.utn.tp5.persistence.AirportPersistence;
import com.utn.tp5.model.Airport;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AirportServiceTest {

    private AirportService airportService;
    private Airport airport;
    private AirportPersistence airportPersistence;

    @Before
    public void contextLoads(){
        this.airportPersistence = mock(AirportPersistence.class);
        this.airportService = new AirportService(airportPersistence);
        this.airport = mock(Airport.class);
        when(airportPersistence.save(this.airport)).thenReturn(this.airport);
        when(airportPersistence.deleteByName(this.airport.getName())).thenReturn(true);
        when(airportPersistence.getOne(this.airport.getId())).thenReturn(this.airport);
    }

    @Test
    public void whenAnAirportIsSaved(){
        Boolean res = this.airportService.saveAirport(this.airport);
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void whenAnAirportIsDeleted(){
        this.airportService.saveAirport(this.airport);
        Boolean res = this.airportService.deleteAirport(this.airport.getName());
        assertEquals(Boolean.TRUE,res);
    }

    @Test
    public void whenAnAirportIsAskedById(){
        Airport c = this.airportService.getById(this.airport.getId());
        assertEquals(this.airport,c);
    }

    @Test
    public void whenTheAirportListIsAsked(){
        List<Airport> expected = new ArrayList<>();
        when(airportPersistence.findAll()).thenReturn(expected);
        List<Airport> cities = this.airportService.getAll();
        assertEquals(cities,expected);
    }

    @Test
    public void whenAnAirportIsModified(){
        this.airport.setName("Test");
        assertTrue(this.airportService.updateAirport(this.airport,(long) 1));
    }
}
