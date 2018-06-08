package com.utn.tp5.Service;

import com.utn.tp5.Persistence.RouteXCabinPersistence;
import com.utn.tp5.model.RouteXCabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RouteXCabinService {

    @Autowired
    RouteXCabinPersistence routeXCabinPersistence;

    public List<RouteXCabin> getAll(){
        return routeXCabinPersistence.findAll();
    }

    public RouteXCabin getById(Long id){
        return routeXCabinPersistence.getOne(id);
    }

    public void saveRouteXCabin(RouteXCabin rxc){
        routeXCabinPersistence.save(rxc);
    }

    public RouteXCabin modifyRouteXCabin(Long route, Long cabin){
         return routeXCabinPersistence.getByRouteIdAndAndCabinId(route,cabin);
    }

    /*public void deleteRouteXCabin(){
        routeXCabinPersistence.deleteBy(name);
    }*/
}
