package com.utn.tp5.DTO;

import com.utn.tp5.model.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {

    private String iata;
    private String name;
    private CountryDTO country;

    public CityDTO(City city){
        this.iata=city.getIata();
        this.name=city.getName();
        this.country= new CountryDTO(city.getCountry());
    }

    public String getName(){
        return this.name;
    }
}
