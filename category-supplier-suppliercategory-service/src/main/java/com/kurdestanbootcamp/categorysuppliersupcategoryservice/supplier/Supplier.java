package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.Category;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.BaseEntity;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category.SupplierCategory;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl_supplier")
@Data
@Audited
public class Supplier extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<SupplierCategory> supplierCategories;


}
