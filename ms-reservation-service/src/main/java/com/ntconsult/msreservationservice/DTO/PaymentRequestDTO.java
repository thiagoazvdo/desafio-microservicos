package com.ntconsult.msreservationservice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentRequestDTO {

//    @CreationTimestamp
    @NotNull(message = "Date is required")
    private LocalDate paymentData;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotBlank(message = "Payment status is required")
    private String paymentStatus;
}