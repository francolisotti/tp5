package com.utn.tp5.DTO;

import com.utn.tp5.model.Airport;
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

    public AirportDTO(Airport airport){
        this.name=airport.getName();
        this.iata=airport.getIata();
        this.city = new CityDTO(airport.getCity());
        this.latitude=airport.getLatitude();
        this.longitude=airport.getLongitude();
    }
}
