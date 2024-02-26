package com.vti.shoppera66backend.config.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed", "localizedMessage"})
public class AppException extends RuntimeException{
    private Instant timestamp; // Thời gian xảy ra lỗi
    private int status; // Trạng thái, mã lỗi
    private String message; // Nguyên nhân xảy ra lỗi
    private String path; // API xả ra lỗi

    public AppException(int status, String error) {
        this.timestamp = Instant.now();
        this.status = status;
        this.message = error;
    }

    public AppException(ErrorResponseEnum responseEnum) {
        this.timestamp = Instant.now();
        this.status = responseEnum.status;
        this.message = responseEnum.message;
    }
}
