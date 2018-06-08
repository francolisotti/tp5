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
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_country")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="iso")
    private String iso;

    public Country(String name,String iso){
        this.name=name;
        this.iso=iso;
    }


}
