package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SupplierMapper.class})
public interface SupplierCategoryMapper {


    SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO);

    SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory);

    List<SupplierCategoryDTO> toSupplierCategoryDTOS(List<SupplierCategory> supplierCategories);

    List<SupplierCategory> toSupplierCategories(List<SupplierCategoryDTO> supplierCategoryDTOS);


}
