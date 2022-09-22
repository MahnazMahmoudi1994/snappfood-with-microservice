package com.kurdestanbootcamp.addressservice.address;

import java.util.List;

public interface IAddressService {

    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
    Address getById(Long id);
    List<Address> getAll();

    List<Address> getAllByUser(Long userId);


}
