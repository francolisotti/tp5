package com.utn.tp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="cabins")
public class Cabin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_cabin")
    private Long id;

    @Column(name="name")
    private String name;

    public Cabin(String name){
        this.name=name;
    }

}
