package com.kurdestanbootcamp.basketitemservice.basket_item;



import java.util.List;
import java.util.Map;

public interface IBasketItemService {

    BasketItem save(BasketItem basketItem);
    BasketItem update(BasketItem basketItem);
    void delete(Long id);
    Map<String, Object> getById(Long id);
    BasketItem getById2(Long id);
    List<BasketItem> getAll();

    List<BasketItem> getAllByBasket(Long basketId);

    List<BasketItem> getAllByItem(Long itemId);




}
