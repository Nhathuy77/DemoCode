package com.vti.shoppera66backend.modal.dto;

import com.vti.shoppera66backend.config.anotation.NotAdmin;
import com.vti.shoppera66backend.modal.entity.ProductStatus;
import com.vti.shoppera66backend.modal.entity.ProductType;
import com.vti.shoppera66backend.modal.entity.ShippingUnit;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class ProductCreatRequestDto {
    @NotBlank(message = "{product.create.name.notBlank}")// null và ""
    @Length(max = 255, message = "Tên không được quá 5 ký tự")
    @NotAdmin
    private String name;
    // Điều kiện gì để khi thêm mới ko bị lỗi
    // + Ko bị trùng trong DB
    // + Ko bị null, ""
    // + Ko quá dài <= 255
    // + Một số yêu cầu đặc biệt khác: Ko chứa ký tự đăc biệt, trim() đầu cuối -> length > 0,...

    @NotBlank(message = "Ảnh không được để trống")
    private String image;
    private int price;
    private ProductStatus status;
    private ShippingUnit shippingUnit;
    private ProductType productType;
}
