package com.utn.tp5.controllers;

import com.utn.tp5.DTO.PriceDTO;
import com.utn.tp5.serviceee.PriceService;
import com.utn.tp5.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/", produces = "application/json")
    public List<PriceDTO> listPrices() {
        List<Price> prices = priceService.getAll();

        List<PriceDTO> rtn = new ArrayList<>();
        for (Price price : prices){
            rtn.add(new PriceDTO(price));
        }
        return rtn;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public PriceDTO getPriceById(@PathVariable("id") Long id){
        Price price = priceService.getById(id);
        PriceDTO rtn = new PriceDTO(price);
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
