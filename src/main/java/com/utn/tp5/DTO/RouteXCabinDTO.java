package com.utn.tp5.DTO;

import com.utn.tp5.model.RouteXCabin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RouteXCabinDTO {

    private CabinDTO cabin;
    private RouteDTO route;
    private PriceDTO price;

    public RouteXCabinDTO(RouteXCabin routeXCabin){
        this.cabin = new CabinDTO(routeXCabin.getCabin());
        this.route = new RouteDTO(routeXCabin.getRoute());
        this.price = new PriceDTO(routeXCabin.getPrice());
    }
}
