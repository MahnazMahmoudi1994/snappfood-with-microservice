package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.CategoryMapper;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.LocationDTO;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface SupplierMapper {

    @Mappings({
            @Mapping(source = "locationDTO", target = "location", ignore = false, qualifiedByName = "locationDtoToLocation")})
    Supplier toSupplier(SupplierDTO supplierDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", ignore = false, qualifiedByName = "locationToLocationDTO")})
    SupplierDTO toSupplierDTO(Supplier supplier);

    List<SupplierDTO> toSupplierDTOS(List<Supplier> suppliers);

    List<Supplier> toSuppliers(List<SupplierDTO> supplierDTOS);


    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        if (locationDTO!=null) {
            Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
            return  candidPoint;
        }
        return null;
    }

    @Named("locationToLocationDTO")
    default  LocationDTO  convertLocationToLocationDTO(Point<G2D> point) {
        if (point!=null) {
            G2D g2D=   point.getPosition();
            LocationDTO locationDTO=new LocationDTO();
            locationDTO.setLat(g2D.getLat());
            locationDTO.setLng(g2D.getLon());
            return  locationDTO;
        }
        return null;
    }

}
