package com.utn.tp5.controllers;

import com.utn.tp5.serviceee.CityService;
import com.utn.tp5.DTO.CityDTO;
import com.utn.tp5.model.City;
import com.utn.tp5.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CityControllerTest {

    private CityController cityController;
    private CityService cityService;
    private City city;
    private Country country;

    @Before
    public void contextLoads(){
        this.cityService = mock(CityService.class);
        this.cityService = mock(CityService.class);
        this.cityController = new CityController(cityService);
        this.country = mock(Country.class);
        this.city = new City("Example","Exa",this.country);
        this.city.setId((long)1);
        when(this.cityService.getById((long)1)).thenReturn(this.city);
        when(this.cityService.saveCity(this.city)).thenReturn(true);
    }

    @Test
    public void wheCityListIsAsked(){
        List<City> cities = new ArrayList<>();
        cities.add(this.city);
        when(this.cityService.getAll()).thenReturn(cities);
        List<CityDTO> DTOList = cityController.listCities();
        for (City city : cities){
            DTOList.add(new CityDTO(city));
        }
        assertEquals(cities.get(0).getName(),DTOList.get(0).getName());
    }

    @Test
    public void whenACityIsAskedById(){
        CityDTO a = cityController.getCityById(this.city.getId());
        CityDTO b = new CityDTO(this.city);
        assertEquals(a.getName(),b.getName());
    }

    @Test
    public void whenACityIsAdded(){
    }

    @Test
    public void whenACityIsDeleted(){

    }
}
