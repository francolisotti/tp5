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
    private int id;

    @Column(name="name")
    private String nombre;
}
