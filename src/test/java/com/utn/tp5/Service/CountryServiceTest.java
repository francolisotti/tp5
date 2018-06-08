package com.utn.tp5.Service;

import com.utn.tp5.Persistence.CountryPersistence;
import com.utn.tp5.model.Country;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CountryServiceTest {

    private CountryService countryService;
    private Country country;

    @Before
    public void contextLoads(){
        CountryPersistence countryPersistence = mock(CountryPersistence.class);
        this.countryService = new CountryService(countryPersistence);
        this.country = mock(Country.class);
    }

    @Test
    public void whenACountryIsSaved(){
        Boolean res = this.countryService.saveCountry(this.country);
        assertEquals(java.util.Optional.of(true),res);
    }
    
    @Test
    public void whenACountryIsDeleted(){
        this.countryService.saveCountry(this.country);
        Boolean res = this.countryService.deleteCountry(this.country.getName());
        assertEquals(java.util.Optional.of(true),res);
    }
}
