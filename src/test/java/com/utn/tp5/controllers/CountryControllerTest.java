package com.utn.tp5.controllers;

import com.utn.tp5.CountryService;
import com.utn.tp5.DTO.CountryDTO;
import com.utn.tp5.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryControllerTest {

    private CountryController countryController;
    private CountryService countryService;
    private Country country;
    private static ModelMapper modelmapper;

    @Before
    public void contextLoads(){
        this.countryService = mock(CountryService.class);
        this.modelmapper = new ModelMapper();
        this.countryController = new CountryController(this.countryService,this.modelmapper);
        this.country = new Country("Example","Exa");
        this.country.setId((long)1);
        when(this.countryService.getById((long)1)).thenReturn(this.country);
        when(this.countryService.saveCountry(this.country)).thenReturn(true);
    }

    @Test
    public void whenCountryListIsAsked(){
        List<Country> countries = new ArrayList<>();
        countries.add(this.country);
        when(this.countryService.getAll()).thenReturn(countries);
        List<CountryDTO> DTOList = countryController.listCountries();
        for (Country country : countries){
            DTOList.add(modelmapper.map(country,CountryDTO.class));
        }
        assertEquals(countries.get(0).getName(),DTOList.get(0).getName());
    }

    @Test
    public void whenACountryIsAskedById(){
        CountryDTO a = countryController.getCountryById(this.country.getId());
        CountryDTO b = modelmapper.map(this.country,CountryDTO.class);
        assertEquals(a.getName(),b.getName());
    }

    @Test
    public void whenACountryIsAdded(){
    }

    @Test
    public void whenACountryIsDeleted(){

    }
}
