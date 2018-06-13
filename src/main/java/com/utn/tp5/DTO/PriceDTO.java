package com.utn.tp5.DTO;

import com.utn.tp5.model.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class PriceDTO {

    private int price;
    private Date dateFrom;

    public PriceDTO(Price price){
        this.price=price.getPrice();
        this.dateFrom=price.getDateFrom();
    }
}
