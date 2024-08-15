package com.ntconsult.mshotelservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @NotBlank
    private String reviewerName;

    @NotBlank
    private String comment;

    @NotNull
    private Double rating;

    @NotBlank
    private Hotel hotel;

}
