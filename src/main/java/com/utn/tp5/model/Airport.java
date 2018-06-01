package com.utn.tp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="airports")
public class Airport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_airport")
    private int id;

    @Column(name="iata")
    private String iata;

    @Column(name="name")
    private String name;

    @OneToOne
    private City city;

    @Column(name="latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    public Airport(String name, String iata, City city, float latitude, float longitude){
        this.name=name;
        this.iata=iata;
        this.city=city;
        this.latitude=latitude;
        this.longitude=longitude;
    }
}
