package com.kurdestanbootcamp.itemservice.item;

import com.kurdestanbootcamp.itemservice.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_item")
@Data
@Audited
public class Item extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "supplier_category_id")
    private Long supplierCategoryId;


}