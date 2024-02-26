package com.vti.shoppera66backend.controller;

import com.vti.shoppera66backend.config.anotation.ProductIDExists;
import com.vti.shoppera66backend.config.exception.AppException;
import com.vti.shoppera66backend.modal.dto.*;
import com.vti.shoppera66backend.modal.entity.Account;
import com.vti.shoppera66backend.modal.entity.Product;
import com.vti.shoppera66backend.service.IAccountService;
import com.vti.shoppera66backend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
@Validated
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchProductRequest request){
        return productService.search(request);
    }

    @PostMapping("/create")
    public Product create(@RequestBody @Valid ProductCreatRequestDto dto){
        return productService.create(dto);
    }

    @PutMapping("/update")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    public Product update(@RequestBody @Valid ProductUpdateRequestDto dto){
        return productService.update(dto);
    }

    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public Product getById(@PathVariable @ProductIDExists int id){
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable @ProductIDExists int id){
        productService.delete(id);
    }
}
