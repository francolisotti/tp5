package com.utn.tp5.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirportDTO {

    private String name;
    private String iata;
    private CityDTO city;
    private float latitude;
    private float longitude;
}
