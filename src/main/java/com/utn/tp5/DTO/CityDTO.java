package com.utn.tp5.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String iata;
    private String name;
    private CountryDTO country;
}
