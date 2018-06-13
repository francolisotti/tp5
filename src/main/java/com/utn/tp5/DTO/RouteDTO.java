package com.utn.tp5.DTO;

import com.utn.tp5.model.Route;
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

    public RouteDTO(Route route){
        this.origin = new AirportDTO((route.getOrigin()));
        this.destination= new AirportDTO(route.getDestination());
        this.distance = route.getDistance();
    }

}
