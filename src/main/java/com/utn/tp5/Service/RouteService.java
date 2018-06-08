package com.utn.tp5.Service;

import com.utn.tp5.Persistence.RoutePersistence;
import com.utn.tp5.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteService {

    @Autowired
    RoutePersistence routePersistence;

    public List<Route> getAll(){
        return routePersistence.findAll();
    }

    public Route getById(Long id){
        return routePersistence.getOne(id);
    }

    public void saveRoute(Route p){
        routePersistence.save(p);
    }

    /*public void deleteRoute(String name){
        routePersistence.deleteByOriginDestination(name);
    }*/
}
