package com.kurdestanbootcamp.basketitemservice.basket_item;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketItemRepository extends PagingAndSortingRepository<BasketItem, Long> {

List<BasketItem> findAllByBasketId(Long basketId);
List<BasketItem> findAllByItemId(Long itemId);


}