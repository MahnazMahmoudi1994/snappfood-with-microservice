package com.kurdestanbootcamp.addressservice.address;

import com.kurdestanbootcamp.addressservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    private final AddressRepository repository;


    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Override
    public Address update(Address address) {

        Address lastAddress = getById(address.getId());

        lastAddress.setLocation(address.getLocation());
        lastAddress.setAddress(address.getAddress());
        lastAddress.setDetails(address.getDetails());
        lastAddress.setPhoneNumber(address.getPhoneNumber());

        return repository.save(lastAddress);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Address getById(Long id) {

        Optional<Address> optionalAddress = repository.findById(id);

        if (!optionalAddress.isPresent()){

            throw new NotFoundException("Address Not Found");
        }

        return optionalAddress.get();
    }

    @Override
    public List<Address> getAll() {

        return (List<Address>) repository.findAll();
    }

    @Override
    public List<Address> getAllByUser(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
