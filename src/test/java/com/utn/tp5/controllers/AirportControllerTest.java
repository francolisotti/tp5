package com.utn.tp5.controllers;

import com.utn.tp5.AirportService;
import com.utn.tp5.CityService;
import com.utn.tp5.DTO.AirportDTO;
import com.utn.tp5.model.Airport;
import com.utn.tp5.model.City;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AirportControllerTest {

    private AirportController airportController;
    private AirportService airportService;
    private CityService cityService;
    private Airport airport;
    private City city;
    private static ModelMapper modelmapper;

    @Before
    public void contextLoads(){
        this.airportService = mock(AirportService.class);
        this.cityService = mock(CityService.class);
        this.modelmapper = new ModelMapper();
        this.airportController = new AirportController(airportService,cityService,this.modelmapper);
        this.city = mock(City.class);
        this.airport = new Airport("Example","Exa",this.city,(float)10.234,(float)15.2324);
        this.airport.setId((long)1);
        when(this.airportService.getById((long)1)).thenReturn(this.airport);
        when(this.airportService.saveAirport(this.airport)).thenReturn(true);
    }

    @Test
    public void whenAirportListIsAsked(){
        List<Airport> airports = new ArrayList<>();
        airports.add(this.airport);
        when(this.airportService.getAll()).thenReturn(airports);
        List<AirportDTO> DTOList = airportController.listAirports();
        for (Airport airport : airports){
            DTOList.add(modelmapper.map(airport,AirportDTO.class));
        }
        assertEquals(airports.get(0).getName(),DTOList.get(0).getName());
    }

    @Test
    public void whenAnAirportIsAskedById(){
        AirportDTO a = airportController.getAirportById(this.airport.getId());
        AirportDTO b = modelmapper.map(this.airport,AirportDTO.class);
        assertEquals(a.getName(),b.getName());
    }

    @Test
    public void whenAnAirportIsAdded(){
    }

    @Test
    public void whenAnAirportIsModified(){
        when(this.airportService.updateAirport(this.airport,this.airport.getId())).thenReturn(true);
        this.airport.setName("Example two");
        this.airportController.modifyById(this.airport,this.airport.getId());
    }

    @Test
    public void whenAnAirportIsDeleted(){

    }
}
