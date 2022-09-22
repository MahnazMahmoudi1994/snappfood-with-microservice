package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.CategoryMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T12:55:30+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Supplier toSupplier(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setLocation( convertLocationDtoToLocation( supplierDTO.getLocationDTO() ) );
        supplier.setId( supplierDTO.getId() );
        supplier.setVersion( supplierDTO.getVersion() );
        supplier.setCreatedDate( supplierDTO.getCreatedDate() );
        supplier.setCreatedBy( supplierDTO.getCreatedBy() );
        supplier.setLastModifiedDate( supplierDTO.getLastModifiedDate() );
        supplier.setLastModifiedBy( supplierDTO.getLastModifiedBy() );
        supplier.setName( supplierDTO.getName() );
        supplier.setAddress( supplierDTO.getAddress() );
        supplier.setLogo( supplierDTO.getLogo() );
        supplier.setCategory( categoryMapper.toCategory( supplierDTO.getCategory() ) );

        return supplier;
    }

    @Override
    public SupplierDTO toSupplierDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setLocationDTO( convertLocationToLocationDTO( supplier.getLocation() ) );
        supplierDTO.setId( supplier.getId() );
        supplierDTO.setVersion( supplier.getVersion() );
        supplierDTO.setCreatedDate( supplier.getCreatedDate() );
        supplierDTO.setCreatedBy( supplier.getCreatedBy() );
        supplierDTO.setLastModifiedDate( supplier.getLastModifiedDate() );
        supplierDTO.setLastModifiedBy( supplier.getLastModifiedBy() );
        supplierDTO.setName( supplier.getName() );
        supplierDTO.setAddress( supplier.getAddress() );
        supplierDTO.setLogo( supplier.getLogo() );
        supplierDTO.setCategory( categoryMapper.toCategoryDTO( supplier.getCategory() ) );

        return supplierDTO;
    }

    @Override
    public List<SupplierDTO> toSupplierDTOS(List<Supplier> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        List<SupplierDTO> list = new ArrayList<SupplierDTO>( suppliers.size() );
        for ( Supplier supplier : suppliers ) {
            list.add( toSupplierDTO( supplier ) );
        }

        return list;
    }

    @Override
    public List<Supplier> toSuppliers(List<SupplierDTO> supplierDTOS) {
        if ( supplierDTOS == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( supplierDTOS.size() );
        for ( SupplierDTO supplierDTO : supplierDTOS ) {
            list.add( toSupplier( supplierDTO ) );
        }

        return list;
    }
}
