package com.utn.tp5.model;

import lombok.AllArgsConstructor;
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
    private Long id;

    @Column(name="iata")
    private String iata;

    @Column(name="name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_country")
    private Country country;

    public City(String name, String iata, Country country){
        this.name=name;
        this.iata=iata;
        this.country=country;
    }
}
