package com.kurdestanbootcamp.addressservice.address;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

List<Address> findAllByUserId(Long userId);

}