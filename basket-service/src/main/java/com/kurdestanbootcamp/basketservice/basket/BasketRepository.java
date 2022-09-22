package com.kurdestanbootcamp.basketservice.basket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket, Long> {

    List<Basket> findAllByAddressId(Long addressId);

    List<Basket> findAllBySupplierId(Long supplierId);

    List<Basket> findAllByStatus(Boolean status);

    Page<Basket> findAll(Pageable pageable);


}