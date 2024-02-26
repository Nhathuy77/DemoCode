package com.vti.shoppera66backend.modal.dto;

import com.vti.shoppera66backend.config.anotation.ProductIDExists;
import com.vti.shoppera66backend.modal.entity.ProductStatus;
import com.vti.shoppera66backend.modal.entity.ProductType;
import com.vti.shoppera66backend.modal.entity.ShippingUnit;
import lombok.Data;

@Data
public class ProductUpdateRequestDto {
    @ProductIDExists(message = "{product.id.notExists}")
    private int id;
    private String name;
    private String image;
    private int price;
    private ProductStatus status;
    private ShippingUnit shippingUnit;
    private ProductType productType;
}
