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
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "origin")
    private Airport origin;

    @OneToOne
    @JoinColumn(name = "destination")
    private Airport destination;

    @Column(name="distance")
    private float distance;

    public Route(float distance, Airport origin, Airport destination){
        this.distance=distance;
        this.origin=origin;
        this.destination=destination;
    }

}
