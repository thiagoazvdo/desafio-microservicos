package com.ntconsult.mshotelservice.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotBlank(message= "Reviewer name is required.")
    private String reviewerName;

    @NotBlank(message = "Comment is required.")
    private String comment;

    @NotNull(message = "Rating is required.")
    private Double rating;

    @NotNull(message = "Hotel ID is required.")
    private Long hotelId;

}
