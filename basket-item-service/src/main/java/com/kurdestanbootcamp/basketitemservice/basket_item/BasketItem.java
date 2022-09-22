package com.kurdestanbootcamp.basketitemservice.basket_item;

import com.kurdestanbootcamp.basketitemservice.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_basket_item",uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id","basket_id"})})
@Data
@Audited
public class BasketItem extends BaseEntity {

    @NotNull
    @Column(name = "count")
    private Integer count;

    @NotNull
    @Column(name = "basket_id")
    private Long basketId;

    @NotNull
    @Column(name = "item_id")
    private Long itemId;
}