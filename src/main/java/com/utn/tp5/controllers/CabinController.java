package com.utn.tp5.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/Cabin")
public class CabinController {
    @RequestMapping("/")
    public String isActive(){
        return "Active";
    }
}
