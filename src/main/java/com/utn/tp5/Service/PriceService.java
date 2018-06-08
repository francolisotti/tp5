package com.utn.tp5.Service;

import com.utn.tp5.Persistence.PricePersistence;
import com.utn.tp5.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
@Service
@Transactional
public class PriceService {

    @Autowired
    PricePersistence pricePersistence;

    public List<Price> getAll(){
        return pricePersistence.findAll();
    }

    public Price getById(Long id){
        return pricePersistence.getOne(id);
    }

    public void savePrice(Price p){
        pricePersistence.save(p);
    }

   /* public void deletePrice(String name){
        pricePersistence.deleteByName(name);
    }*/
}
