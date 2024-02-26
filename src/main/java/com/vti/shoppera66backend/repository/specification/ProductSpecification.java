package com.vti.shoppera66backend.repository.specification;

import com.vti.shoppera66backend.modal.dto.SearchProductRequest;
import com.vti.shoppera66backend.modal.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    /**
     * Hàm để tổng hợp lại các điều kiện từ request
     * @param request : Các điều kiện tìm kiếm
     * @return
     */
    public static Specification<Product> buildCondition(SearchProductRequest request){
        return Specification.where(buildConditionName(request))
                .and(buildConditionProductType(request))
                .and(buildConditionShippingUnit(request))
                .and(buildConditionStatus(request))
                .and(buildConditionPrice(request));
    }

    /**
     * Tạo điều kiện tìm kiếm với product name
     * Sử dụng cri.like tương tự dùng like trong My SQL.
     * @param request
     * @return
     */
    public static Specification<Product> buildConditionName(SearchProductRequest request){
        if (request.getName() != null && !"".equals(request.getName())){
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
                // root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
                // cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("name"), "%" + request.getName() + "%");
            };
        } else {
            return null;
        }
    }

    /**
     * Tạo điều kiện tìm kiếm với danh sách productType
     * Kết quả trả về sẽ là các product có productType nằm trong danh sách productType truyền vào
     * @param request
     * @return
     */
    public static Specification<Product> buildConditionProductType(SearchProductRequest request){
        if (request.getProductType() != null && request.getProductType().size() > 0){
            return (root, query, cri) -> {
                // Tạo điều kiện tìm kiếm với productType. Producttype sẽ là 1 trong các giá trị truyền vào
                return root.get("productType").in(request.getProductType());
            };
        } else {
            return null;
        }
    }

    /**
     * Tạo điều kiện với giá sản phẩm
     * Kết quả trả về là danh sách product có giá nằm trong khoảng min và max truyền vào
     * @param request
     * @return
     */
    public static Specification<Product> buildConditionPrice(SearchProductRequest request){
        if (request.getMinPrice() != 0 && request.getMaxPrice() != 0){ // Nếu ko truyền phần tử nào -> lấy tất cả
            return (root, query, cri) -> {
                return cri.between(root.get("price"), request.getMinPrice(), request.getMaxPrice());
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionShippingUnit(SearchProductRequest request){
        if (request.getShippingUnit() != null && request.getShippingUnit().size() > 0){ // Nếu ko truyền phần tử nào -> lấy tất cả
            return (root, query, cri) -> {
                return root.get("shippingUnit").in(request.getShippingUnit());
            };
        } else {
            return null;
        }
    }

    public static Specification<Product> buildConditionStatus(SearchProductRequest request){
        if (request.getStatus() != null && request.getStatus().size() > 0){ // Nếu ko truyền phần tử nào -> lấy tất cả
            return (root, query, cri) -> {
                return root.get("status").in(request.getStatus());
            };
        } else {
            return null;
        }
    }

}
