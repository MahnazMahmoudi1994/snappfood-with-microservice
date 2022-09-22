package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.BaseEntity;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_supplier_category", uniqueConstraints = {@UniqueConstraint(columnNames = {"supplier_id", "title"})})
@Data
@Audited
public class SupplierCategory extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

}
