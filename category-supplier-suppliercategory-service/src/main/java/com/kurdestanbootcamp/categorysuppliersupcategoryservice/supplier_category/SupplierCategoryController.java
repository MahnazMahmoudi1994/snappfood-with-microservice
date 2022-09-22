package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier-category/")
@AllArgsConstructor
public class SupplierCategoryController {

    private final ISupplierCategoryService supplierCategoryService;
    private SupplierCategoryMapper supplierCategoryMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory =supplierCategoryMapper.toSupplierCategory(supplierCategoryDTO);
        supplierCategoryService.save(supplierCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory =supplierCategoryMapper.toSupplierCategory(supplierCategoryDTO);
        supplierCategoryService.update(supplierCategory);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierCategoryDTO> getById(@PathVariable Long id ){
        SupplierCategory supplierCategory = supplierCategoryService.getById(id);
        SupplierCategoryDTO supplierCategoryDTO =supplierCategoryMapper.toSupplierCategoryDTO(supplierCategory);
        return ResponseEntity.ok(supplierCategoryDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<SupplierCategoryDTO>> getAll(){
        List<SupplierCategory> supplierCategories= supplierCategoryService.getAll();
        List<SupplierCategoryDTO> supplierCategoryDTOS = supplierCategoryMapper.toSupplierCategoryDTOS(supplierCategories);

        return ResponseEntity.ok(supplierCategoryDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        supplierCategoryService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-supplier/{supplierId}")
    public ResponseEntity<List<SupplierCategoryDTO>> getAllBySupplier(@PathVariable Long supplierId){
        List<SupplierCategory> supplierCategories= supplierCategoryService.getAllBySupplier(supplierId);
        List<SupplierCategoryDTO> supplierCategoryDTOS = supplierCategoryMapper.toSupplierCategoryDTOS(supplierCategories);

        return ResponseEntity.ok(supplierCategoryDTOS);
    }

}
