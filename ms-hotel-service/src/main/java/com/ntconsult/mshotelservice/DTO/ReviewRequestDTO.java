package com.ntconsult.mshotelservice.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotBlank(message= "{notBlank.reviewRequestDTO.reviewerName}")
    private String reviewerName;

    @NotBlank(message = "{notBlank.reviewRequestDTO.comment}")
    private String comment;

    @NotNull(message = "{notNull.reviewRequestDTO.rating}")
    private Double rating;

    @NotNull(message = "{notNull.reviewRequestDTO.hotel}")
    private Long hotelId;

}
