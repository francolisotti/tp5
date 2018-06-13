package com.utn.tp5.DTO;

import com.utn.tp5.model.Cabin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CabinDTO {

    private String name;

    public CabinDTO(Cabin cabin){
        this.name=cabin.getName();
    }
}
