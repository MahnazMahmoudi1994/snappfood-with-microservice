package com.kurdestanbootcamp.basketservice.basket;

import com.kurdestanbootcamp.basketservice.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_basket",uniqueConstraints = {@UniqueConstraint(columnNames = {"supplier_id","address_id"})})
@Data
@Audited
public class Basket extends BaseEntity {


    @Column(name = "paid_price")
    private Double paidPrice;

    @Column(name = "status")
    private Boolean status;

    @NotNull
    @Column(name = "address_id")
    private Long addressId;

    @NotNull
    @Column(name = "supplier_id")
    private Long supplierId;

}
