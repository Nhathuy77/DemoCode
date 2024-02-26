package com.vti.shoppera66backend.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")

@Data
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "IMAGE", unique = true, nullable = false)
    private String image;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus status;

    @Column(name = "SHIPPING_UNIT")
    @Enumerated(EnumType.STRING)
    private ShippingUnit shippingUnit;

    @Column(name = "PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType productType;
}
