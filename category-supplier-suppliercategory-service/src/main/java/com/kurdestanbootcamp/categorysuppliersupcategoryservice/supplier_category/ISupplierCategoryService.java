package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;


import java.util.List;

public interface ISupplierCategoryService {

    SupplierCategory save(SupplierCategory supplierCategory);
    SupplierCategory update(SupplierCategory supplierCategory);
    void delete(Long id);
    SupplierCategory getById(Long id);
    List<SupplierCategory> getAll();

    List<SupplierCategory> getAllBySupplier(Long supplierId);



}
