package com.utn.tp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="routexcabin")
public class RouteXCabin /* Flight */ {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cabin_id_cabin")
    private Cabin cabin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="route_id_route")
    private Route route;

    @OneToOne
    @JoinColumn(name="price_id_price")
    private Price price;

    public RouteXCabin(Cabin cabin, Route route, Price price){
        this.cabin=cabin;
        this.route=route;
        this.price=price;
    }
}
