package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.BaseEntity;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_category")
@Data
@Audited
public class Category extends BaseEntity {


    @NotNull
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.ALL)
    private List<Supplier> suppliers;

}
