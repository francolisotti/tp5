package com.utn.tp5.controllers;

import com.utn.tp5.DTO.CountryDTO;
import com.utn.tp5.service.CountryService;
import com.utn.tp5.model.Country;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;
    ModelMapper modelmapper;

    @GetMapping(value = "/", produces = "application/json")
    public List<CountryDTO> listCountries() {
        List<Country> countries = countryService.getAll();
        List<CountryDTO> rtn = new ArrayList<>();
        CountryDTO dto;
        for (Country country : countries){
            dto = modelmapper.map(country,CountryDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public CountryDTO getCountryById(@PathVariable("id") Long id){
        Country country = countryService.getById(id);
        CountryDTO rtn = modelmapper.map(country,CountryDTO.class);
        return rtn;
    }

    @PostMapping(value = "/create")
    public void createCountry(String name, String iso){
        Country country = new Country (name,iso);
        countryService.saveCountry(country);
    }
    @DeleteMapping(value = "/{name}")
    public void deleteCountry(@PathVariable("name") String name){
        countryService.deleteCountry(name);
    }
}
