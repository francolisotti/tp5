package com.utn.tp5.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RouteXCabinDTO {

    private CabinDTO cabin;
    private RouteDTO route;
    private PriceDTO price;
}
