package com.utn.tp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="cities")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_city")
    private int id;

    @Column(name="iata")
    private String iata;

    @Column(name="name")
    private String name;

    @ManyToOne
    private Country country;

    public City(String name, String iata, Country country){
        this.name=name;
        this.iata=iata;
        this.country=country;
    }
}
