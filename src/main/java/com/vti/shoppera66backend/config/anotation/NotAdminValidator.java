package com.vti.shoppera66backend.config.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ConstraintValidator<A, T>;
 * Trong đó: A: Là anotation vừa tạo ở bước 1
 *           B: Là kiểu dữ liệu mà mình muốn validate
 */
public class NotAdminValidator implements ConstraintValidator<NotAdmin, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
       return !name.contains("ADMIN");

    }
}
