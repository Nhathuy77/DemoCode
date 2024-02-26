package com.vti.shoppera66backend.modal.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Data
@MappedSuperclass // Để đánh dấu class này cũng là 1 phần trong các entity khác
public class BaseEntity {
    @Column(name = "CREATE_DATE")
    protected Date createDate;

    @Column(name = "CREATE_BY")
    protected String createBy;

    @Column(name = "UPDATE_DATE")
    protected Date updateDate;

    @Column(name = "UPDATE_BY")
    protected String updateBy;

    /**
     * Hàm này gọi khi entity được thêm mới
     */
    @PrePersist
    public void onPrePersist(){
        this.createDate = new Date();
        this.createBy = "Mr.Uoc Create";
    }

    /**
     * Hàm này gọi tới khi entity được update
     */
    @PreUpdate
    public void onPreUpdate(){
        this.updateDate = new Date();
        this.updateBy = "MrUoc Update";
    }
}
