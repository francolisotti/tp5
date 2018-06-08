package com.utn.tp5.DTO;

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
}
