package com.utn.tp5.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="prices")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_price")
    private Long id;

    @Column(name="price")
    private int price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="date")
    private Date dateFrom;

    public Price (int price, Date dateFrom){
        this.price=price;
        this.dateFrom=dateFrom;
    }
}
