package com.kurdestanbootcamp.basketservice.basket;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IBasketService {

    Basket save(Basket basket);
    Basket update(Basket basket);
    void delete(Long id);
    Basket getById(Long id);
    List<Basket> getAll();

    List<Basket> getAllByAddress(Long addressId);

    List<Basket> getAllBySupplier(Long supplierId);

    List<Basket> getAllByStatus(Boolean status);

    Page<Basket> paging(Integer page, Integer size);



}
