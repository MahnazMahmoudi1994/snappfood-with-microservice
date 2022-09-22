package com.kurdestanbootcamp.addressservice.address;

import com.kurdestanbootcamp.addressservice.common.LocationDTO;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "locationDTO", target = "location", ignore = false, qualifiedByName = "locationDtoToLocation")})
    Address toAddress(AddressDTO addressDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", ignore = false, qualifiedByName = "locationToLocationDTO")})
    AddressDTO toAddressDTO(Address address);

    List<AddressDTO> toAddressDTOS(List<Address> addresses);

    List<Address> toAddresses(List<AddressDTO> addressDTOS);


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
