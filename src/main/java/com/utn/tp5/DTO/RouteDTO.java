package com.utn.tp5.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RouteDTO {

    private AirportDTO origin;
    private AirportDTO destination;
    private float distance;

}
