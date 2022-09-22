package com.kurdestanbootcamp.addressservice.address;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T12:30:54+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setLocation( convertLocationDtoToLocation( addressDTO.getLocationDTO() ) );
        address.setId( addressDTO.getId() );
        address.setVersion( addressDTO.getVersion() );
        address.setCreatedDate( addressDTO.getCreatedDate() );
        address.setCreatedBy( addressDTO.getCreatedBy() );
        address.setLastModifiedDate( addressDTO.getLastModifiedDate() );
        address.setLastModifiedBy( addressDTO.getLastModifiedBy() );
        address.setAddress( addressDTO.getAddress() );
        address.setDetails( addressDTO.getDetails() );
        address.setPhoneNumber( addressDTO.getPhoneNumber() );
        address.setUserId( addressDTO.getUserId() );

        return address;
    }

    @Override
    public AddressDTO toAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setLocationDTO( convertLocationToLocationDTO( address.getLocation() ) );
        addressDTO.setId( address.getId() );
        addressDTO.setVersion( address.getVersion() );
        addressDTO.setCreatedDate( address.getCreatedDate() );
        addressDTO.setCreatedBy( address.getCreatedBy() );
        addressDTO.setLastModifiedDate( address.getLastModifiedDate() );
        addressDTO.setLastModifiedBy( address.getLastModifiedBy() );
        addressDTO.setAddress( address.getAddress() );
        addressDTO.setDetails( address.getDetails() );
        addressDTO.setPhoneNumber( address.getPhoneNumber() );
        addressDTO.setUserId( address.getUserId() );

        return addressDTO;
    }

    @Override
    public List<AddressDTO> toAddressDTOS(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toAddressDTO( address ) );
        }

        return list;
    }

    @Override
    public List<Address> toAddresses(List<AddressDTO> addressDTOS) {
        if ( addressDTOS == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOS.size() );
        for ( AddressDTO addressDTO : addressDTOS ) {
            list.add( toAddress( addressDTO ) );
        }

        return list;
    }
}
