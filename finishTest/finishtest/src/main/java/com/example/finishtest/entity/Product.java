package com.example.finishtest.entity;

import com.example.finishtest.model.ProductStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String type;
    private String desc;
    private double price;
    private String image;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    private int status = ProductStatus.PRODUCT_PENDING;
    public boolean isActive(){
        return this.status == ProductStatus.PRODUCT_GOING || this.status==ProductStatus.PRODUCT_PENDING;
    }

    public boolean isCancel(){
        return this.status == ProductStatus.PRODUCT_CANCEL;

    }
    public boolean isFinish(){
        return this.status == ProductStatus.PRODUCT_FINISH;
    }
}
