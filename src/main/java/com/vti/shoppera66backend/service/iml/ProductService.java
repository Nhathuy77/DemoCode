package com.vti.shoppera66backend.service.iml;

import com.vti.shoppera66backend.config.exception.AppException;
import com.vti.shoppera66backend.config.exception.ErrorResponseEnum;
import com.vti.shoppera66backend.modal.dto.BaseRequest;
import com.vti.shoppera66backend.modal.dto.ProductCreatRequestDto;
import com.vti.shoppera66backend.modal.dto.ProductUpdateRequestDto;
import com.vti.shoppera66backend.modal.dto.SearchProductRequest;
import com.vti.shoppera66backend.modal.entity.Product;
import com.vti.shoppera66backend.repository.ProductRepository;
import com.vti.shoppera66backend.repository.specification.ProductSpecification;
import com.vti.shoppera66backend.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class) // rollbackFor
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> search(SearchProductRequest request) {
        PageRequest pageRequest = null;
        if ("DESC".equals(request.getSortType())){
            // Giá trị page mà thư viện mong muốn để vào trang đầu tiên: 0
            // Giá trị mình muốn để lấy trang đầu tiền: 1 - 1
            pageRequest = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.by(request.getSortField()).descending());
        } else {
            pageRequest = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.by(request.getSortField()).ascending());
        }
        Specification<Product> condition = ProductSpecification.buildCondition(request);
        return productRepository.findAll(condition, pageRequest);
    }

    @Override
    public Product create(ProductCreatRequestDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return productRepository.save(product);
    }

    @Override
    public Product update(ProductUpdateRequestDto dto) {
        Optional<Product> productOptional = productRepository.findById(dto.getId());
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            BeanUtils.copyProperties(dto, product);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            return productOptional.get();
        }
        throw new AppException(ErrorResponseEnum.NOT_FOUND_PRODUCT);
    }

    @Override
    public void delete(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new AppException(ErrorResponseEnum.NOT_FOUND_PRODUCT);
        }
    }
}
