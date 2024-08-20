package com.ntconsult.msreservationservice.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerRequestDTO {

    @NotNull(message = "{notNull.customerRequestDTO.id}")
    private Long id;

//    @NotBlank(message = "{notBlank.customerRequestDTO.name}")
    private String name;

//    @NotBlank(message = "{notBlank.customerRequestDTO.contact}")
    private String contact;

}
