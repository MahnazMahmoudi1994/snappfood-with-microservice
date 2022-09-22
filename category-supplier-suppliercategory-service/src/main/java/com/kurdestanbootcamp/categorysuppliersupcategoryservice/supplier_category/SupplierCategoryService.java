package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception.ConflictException;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception.NotFoundException;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.ISupplierService;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierCategoryService implements ISupplierCategoryService {

    private  final SupplierCategoryRepository repository;
    private  final ISupplierService supplierService;


    @Caching(evict = {
            @CacheEvict(value = "supplierCategory", allEntries = true),
            @CacheEvict(value = "supplierCategory2", allEntries = true)
    })
    @Override
    public SupplierCategory save(SupplierCategory supplierCategory) {
        Long supplierId = supplierCategory.getSupplier().getId();
        List<SupplierCategory> supplierCategories = getAll();
        for (SupplierCategory supplierCategory1:supplierCategories){
            if ((supplierCategory1.getTitle().equals(supplierCategory.getTitle())) &&
                    (supplierCategory1.getSupplier().getId().equals(supplierId))){
                throw new ConflictException("This SupplierCategory has already been registered");
            }
        }


        Supplier supplier = supplierService.getById(supplierId);
        supplierCategory.setSupplier(supplier);
        return repository.save(supplierCategory);
    }

    @Caching(evict = {
            @CacheEvict(value = "supplierCategory", allEntries = true),
            @CacheEvict(value = "supplierCategory2", allEntries = true)
    })
    @Override
    public SupplierCategory update(SupplierCategory supplierCategory) {
        SupplierCategory lastSupplierCategory = getById(supplierCategory.getId());
        Long supplierId = supplierCategory.getSupplier().getId();

        List<SupplierCategory> supplierCategories = getAll();
        for (SupplierCategory supplierCategory1:supplierCategories){
            if ((supplierCategory1.getTitle().equals(supplierCategory.getTitle())) &&
                    (supplierCategory1.getSupplier().getId().equals(supplierId))){
                if(supplierCategory1.getId() == supplierCategory.getId()){
                    continue;
                }
                throw new ConflictException("This SupplierCategory has already been registered");
            }
        }

        lastSupplierCategory.setTitle(supplierCategory.getTitle());
        lastSupplierCategory.setLogo(supplierCategory.getLogo());

        Supplier supplier = supplierService.getById(supplierId);
        lastSupplierCategory.setSupplier(supplier);

        return repository.save(lastSupplierCategory);
    }

    @Caching(evict = {
            @CacheEvict(value = "supplierCategory", allEntries = true),
            @CacheEvict(value = "supplierCategory2", allEntries = true)
    })
    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Cacheable(value = "supplierCategory2",key = "#id")
    @Override
    public SupplierCategory getById(Long id) {
        Optional<SupplierCategory> optionalSupplierCategory=repository.findById(id);

        if (!optionalSupplierCategory.isPresent()){

            throw new NotFoundException("SupplierCategory Not Found");
        }

        return optionalSupplierCategory.get();
    }

    @Cacheable(value = "supplierCategory")
    @Override
    public List<SupplierCategory> getAll() {
        return (List<SupplierCategory>) repository.findAll();
    }

    @Override
    public List<SupplierCategory> getAllBySupplier(Long supplierId) {
        Supplier supplier = supplierService.getById(supplierId);
        return repository.findAllBySupplier(supplier);
    }
}
