package com.ntconsult.msreservationservice.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentRequestDTO {

    @NotNull(message = "{notNull.paymentRequestDTO.paymentData}")
    private LocalDate paymentData;

    @NotNull(message = "{notNull.paymentRequestDTO.amount}")
    private Double amount;

    @NotBlank(message = "{notBlank.paymentRequestDTO.paymentStatus}")
    private String paymentStatus;
}