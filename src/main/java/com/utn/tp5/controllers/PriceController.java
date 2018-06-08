package com.utn.tp5.controllers;

import com.utn.tp5.DTO.PriceDTO;
import com.utn.tp5.Service.PriceService;
import com.utn.tp5.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.utn.tp5.Tp5Application.modelmapper;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/", produces = "application/json")
    public List<PriceDTO> listPrices() {
        List<Price> prices = priceService.getAll();

        List<PriceDTO> rtn = new ArrayList<>();
        PriceDTO dto;
        for (Price price : prices){
            dto = modelmapper.map(price,PriceDTO.class);
            rtn.add(dto);
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public PriceDTO getPriceById(@PathVariable("id") Long id){
        Price price = priceService.getById(id);
        PriceDTO rtn = modelmapper.map(price,PriceDTO.class);
        return rtn;
    }

    @PostMapping(value = "/create")
    public void createPrice(int price, Date dateFrom){
        Price country = new Price (price, dateFrom);
        priceService.savePrice(country);
    }

    /*@DeleteMapping(value = "/{name}")
    public void deletePrice(@PathVariable("name") String name){
        priceService.deletePrice(name);
    }*/
}
