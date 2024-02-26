package com.vti.shoppera66backend.modal.dto;

import com.vti.shoppera66backend.modal.entity.ProductStatus;
import com.vti.shoppera66backend.modal.entity.ProductType;
import com.vti.shoppera66backend.modal.entity.ShippingUnit;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class SearchProductRequest extends BaseRequest {
    private String name;
    private int minPrice;
    private int maxPrice;
    private Date createDateMin;
    private Date createDateMax;
    private Set<ProductStatus> status;
    private Set<ShippingUnit> shippingUnit;
    private Set<ProductType> productType;
}
