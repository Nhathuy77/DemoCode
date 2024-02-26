package com.vti.shoppera66backend.modal.dto;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OrderCreateRequestDto {
    private int productId;
    private int accountId;
    @Positive
    private int quantity;
}
