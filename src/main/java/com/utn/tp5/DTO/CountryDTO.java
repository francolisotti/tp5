package com.utn.tp5.DTO;

import com.utn.tp5.model.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CountryDTO {

    private String name;
    private String iso;

    public CountryDTO(Country country){
        this.name=country.getName();
        this.iso=country.getIso();
    }
}
