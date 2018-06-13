package com.utn.tp5.controllers;

import com.utn.tp5.DTO.CabinDTO;
<<<<<<< HEAD
import com.utn.tp5.service.CabinService;
=======
import com.utn.tp5.Service.CabinService;
>>>>>>> parent of 9056e30... Tests
import com.utn.tp5.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.utn.tp5.Tp5Application.modelmapper;

@RestController
@RequestMapping(value = "/cabin")
public class CabinController {
    @Autowired
    CabinService cabinService;

    @GetMapping(value = "/", produces = "application/json")
    public List<CabinDTO> listCabins() {
        List<Cabin> cabins = cabinService.getAll();
        List<CabinDTO> rtn = new ArrayList<>();
        CabinDTO dto;
        for (Cabin cabin : cabins){
            dto = modelmapper.map(cabin,CabinDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public CabinDTO getCabinById(@PathVariable("id") Long id){
        Cabin cabin = cabinService.getById(id);
        CabinDTO rtn = modelmapper.map(cabin,CabinDTO.class);
        return rtn;
    }

    @GetMapping(value = "/create/{name}")
    public void createCabin(@PathVariable("name") String name){
        Cabin cabin = new Cabin (name);
        cabinService.saveCabin(cabin);
    }

    @DeleteMapping(value = "/delete/{name}")
    public void deleteCountry(@PathVariable("name") String name){
        cabinService.deleteCabin(name);
    }
}
