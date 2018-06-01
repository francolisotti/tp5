package com.utn.tp5.model;

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
    @Column(name="id_route")
    private int id;

    @OneToOne
    private City origin;

    @OneToOne
    private City destination;

    @Column(name="distance")
    private float distance;
}
