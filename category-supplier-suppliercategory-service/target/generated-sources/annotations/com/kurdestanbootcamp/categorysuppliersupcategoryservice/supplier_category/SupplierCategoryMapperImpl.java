package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier_category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier.SupplierMapper;
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
public class SupplierCategoryMapperImpl implements SupplierCategoryMapper {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO) {
        if ( supplierCategoryDTO == null ) {
            return null;
        }

        SupplierCategory supplierCategory = new SupplierCategory();

        supplierCategory.setId( supplierCategoryDTO.getId() );
        supplierCategory.setVersion( supplierCategoryDTO.getVersion() );
        supplierCategory.setCreatedDate( supplierCategoryDTO.getCreatedDate() );
        supplierCategory.setCreatedBy( supplierCategoryDTO.getCreatedBy() );
        supplierCategory.setLastModifiedDate( supplierCategoryDTO.getLastModifiedDate() );
        supplierCategory.setLastModifiedBy( supplierCategoryDTO.getLastModifiedBy() );
        supplierCategory.setTitle( supplierCategoryDTO.getTitle() );
        supplierCategory.setLogo( supplierCategoryDTO.getLogo() );
        supplierCategory.setSupplier( supplierMapper.toSupplier( supplierCategoryDTO.getSupplier() ) );

        return supplierCategory;
    }

    @Override
    public SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory) {
        if ( supplierCategory == null ) {
            return null;
        }

        SupplierCategoryDTO supplierCategoryDTO = new SupplierCategoryDTO();

        supplierCategoryDTO.setId( supplierCategory.getId() );
        supplierCategoryDTO.setVersion( supplierCategory.getVersion() );
        supplierCategoryDTO.setCreatedDate( supplierCategory.getCreatedDate() );
        supplierCategoryDTO.setCreatedBy( supplierCategory.getCreatedBy() );
        supplierCategoryDTO.setLastModifiedDate( supplierCategory.getLastModifiedDate() );
        supplierCategoryDTO.setLastModifiedBy( supplierCategory.getLastModifiedBy() );
        supplierCategoryDTO.setTitle( supplierCategory.getTitle() );
        supplierCategoryDTO.setLogo( supplierCategory.getLogo() );
        supplierCategoryDTO.setSupplier( supplierMapper.toSupplierDTO( supplierCategory.getSupplier() ) );

        return supplierCategoryDTO;
    }

    @Override
    public List<SupplierCategoryDTO> toSupplierCategoryDTOS(List<SupplierCategory> supplierCategories) {
        if ( supplierCategories == null ) {
            return null;
        }

        List<SupplierCategoryDTO> list = new ArrayList<SupplierCategoryDTO>( supplierCategories.size() );
        for ( SupplierCategory supplierCategory : supplierCategories ) {
            list.add( toSupplierCategoryDTO( supplierCategory ) );
        }

        return list;
    }

    @Override
    public List<SupplierCategory> toSupplierCategories(List<SupplierCategoryDTO> supplierCategoryDTOS) {
        if ( supplierCategoryDTOS == null ) {
            return null;
        }

        List<SupplierCategory> list = new ArrayList<SupplierCategory>( supplierCategoryDTOS.size() );
        for ( SupplierCategoryDTO supplierCategoryDTO : supplierCategoryDTOS ) {
            list.add( toSupplierCategory( supplierCategoryDTO ) );
        }

        return list;
    }
}
