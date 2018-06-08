package com.utn.tp5.Service;

import com.utn.tp5.Persistence.CabinPersistence;
import com.utn.tp5.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CabinService {

    @Autowired
    CabinPersistence cabinPersistence;

    public List<Cabin> getAll(){
        return cabinPersistence.findAll();
    }

    public Cabin getById(Long id){
        return cabinPersistence.getOne(id);
    }

    public void saveCabin(Cabin c){
        cabinPersistence.save(c);
    }

    public void deleteCabin(String name){
        cabinPersistence.deleteByName(name);
    }
}
