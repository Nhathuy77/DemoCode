package com.vti.shoppera66backend.config.exception;

public enum ErrorResponseEnum {
    NOT_FOUND_PRODUCT(404, "Không tìm thấy sản phẩm"),
    NOT_FOUND_ACCOUNT(404, "Không tìm thấy người dùng"),
    USERNAME_EXISTED(400, "Username đã tồn tại!");


    public final int status;
    public final String message;
    ErrorResponseEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
