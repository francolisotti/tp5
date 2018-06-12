package com.utn.tp5.controllers;

import com.utn.tp5.DTO.PriceDTO;
import com.utn.tp5.PriceService;
import com.utn.tp5.model.Price;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceControllerTest {

    private PriceController priceController;
    private PriceService priceService;
    private Price price;
    private static ModelMapper modelmapper;

    @Before
    public void contextLoads(){
        this.priceService = mock(PriceService.class);
        this.modelmapper = new ModelMapper();
        this.priceController = new PriceController(this.priceService,this.modelmapper);
        this.price = new Price(1234,mock(Date.class));
        this.price.setId((long)1);
        when(this.priceService.getById((long)1)).thenReturn(this.price);
        when(this.priceService.savePrice(this.price)).thenReturn(true);
    }

    @Test
    public void whenPriceListIsAsked(){
        List<Price> prices = new ArrayList<>();
        prices.add(this.price);
        when(this.priceService.getAll()).thenReturn(prices);
        List<PriceDTO> DTOList = priceController.listPrices();
        for (Price price : prices){
            DTOList.add(modelmapper.map(price,PriceDTO.class));
        }
        assertEquals(prices.get(0).getPrice(),DTOList.get(0).getPrice());
    }

    @Test
    public void whenAPriceIsAskedById(){
        PriceDTO a = priceController.getPriceById(this.price.getId());
        PriceDTO b = modelmapper.map(this.price,PriceDTO.class);
        assertEquals(a.getPrice(),b.getPrice());
    }

    @Test
    public void whenAPriceIsAdded(){
    }

    @Test
    public void whenAPriceIsDeleted(){

    }
}
