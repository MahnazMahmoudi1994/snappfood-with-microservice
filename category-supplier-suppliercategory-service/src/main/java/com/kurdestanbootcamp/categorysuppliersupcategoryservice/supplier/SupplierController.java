package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;


import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.PagingData;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier/")
@AllArgsConstructor
public class SupplierController {

    private final ISupplierService supplierService;
    private SupplierMapper supplierMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier =supplierMapper.toSupplier(supplierDTO);
        supplierService.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier =supplierMapper.toSupplier(supplierDTO);
        supplierService.update(supplier);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierDTO> getById(@PathVariable Long id ){
        Supplier supplier = supplierService.getById(id);
        SupplierDTO supplierDTO =supplierMapper.toSupplierDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<SupplierDTO>> getAll(){
        List<Supplier> suppliers= supplierService.getAll();
        List<SupplierDTO> supplierDTOS = supplierMapper.toSupplierDTOS(suppliers);

        return ResponseEntity.ok(supplierDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        supplierService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-category/{categoryId}")
    public ResponseEntity<List<SupplierDTO>> getAllByCategory(@PathVariable Long categoryId){
        List<Supplier> suppliers= supplierService.getAllByCategory(categoryId);
        List<SupplierDTO> supplierDTOS = supplierMapper.toSupplierDTOS(suppliers);

        return ResponseEntity.ok(supplierDTOS);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<SupplierDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<Supplier> supplierPage= supplierService.paging(page,size);

        int totalPage=  supplierPage.getTotalPages();
        List<Supplier> data= supplierPage.getContent();
        List<SupplierDTO> supplierDTOS= supplierMapper.toSupplierDTOS(data);

        PagingData<SupplierDTO> pagingData=new PagingData<>(totalPage,page,supplierDTOS);


        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<SupplierDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<Supplier> suppliers = supplierService.search(searchCriteria);
        List<SupplierDTO> supplierDTOS = supplierMapper.toSupplierDTOS(suppliers);
        return ResponseEntity.ok(supplierDTOS);
    }

    @GetMapping("/v1/{lat}/{lng}/{distance}")
    public ResponseEntity getAllSupplierByDistanceAndPoint(
            @PathVariable("lat") double lat,
            @PathVariable("lng") double lng,
            @PathVariable("distance") double distance){
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);
        List<Supplier> suppliers = supplierService.getAllSupplierByDistanceAndPoint(candidPoint, distance);
        List<SupplierDTO> supplierDTOS =supplierMapper.toSupplierDTOS(suppliers);
        return ResponseEntity.ok(supplierDTOS);
    }

}
