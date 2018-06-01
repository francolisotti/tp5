package com.utn.tp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int id;

    @Column(name="price")
    private int price;

    @Column(name="date")
    private Date date;
}
