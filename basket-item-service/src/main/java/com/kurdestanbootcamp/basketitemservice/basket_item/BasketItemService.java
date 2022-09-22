package com.kurdestanbootcamp.basketitemservice.basket_item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kurdestanbootcamp.basketitemservice.basket_client.BasketClient;
import com.kurdestanbootcamp.basketitemservice.basket_client.BasketDTO;
import com.kurdestanbootcamp.basketitemservice.common.exception.ConflictException;
import com.kurdestanbootcamp.basketitemservice.common.exception.NotFoundException;
import com.kurdestanbootcamp.basketitemservice.item_client.ItemClient;
import com.kurdestanbootcamp.basketitemservice.item_client.ItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketItemService implements IBasketItemService {

    private final BasketItemRepository repository;
    private final BasketClient basketClient;
    private final ItemClient itemClient;


    @Override
    public BasketItem save(BasketItem basketItem) {

        List<BasketItem> basketItems = getAll();
        for (BasketItem basketItem1:basketItems){
            if ((basketItem1.getBasketId().equals(basketItem.getBasketId())) &&
                    (basketItem1.getItemId().equals(basketItem.getItemId()))){
                throw new ConflictException("This BasketItem has already been registered");
            }
        }

        return repository.save(basketItem);
    }

    @Override
    public BasketItem update(BasketItem basketItem) {

        BasketItem lastBasketItem= getById2(basketItem.getId());
        List<BasketItem> basketItems = getAll();
        for (BasketItem basketItem1:basketItems){
            if ((basketItem1.getBasketId().equals(basketItem.getBasketId())) &&
                    (basketItem1.getItemId().equals(basketItem.getItemId()))){
                if(basketItem1.getId() == basketItem.getId()){
                    continue;
                }
                throw new ConflictException("This BasketItem has already been registered");
            }
        }

        lastBasketItem.setCount(basketItem.getCount());
        return repository.save(lastBasketItem);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Map<String, Object> getById(Long id) {


        Optional<BasketItem> optionalBasketItem=repository.findById(id);

        if (!optionalBasketItem.isPresent()){

            throw new NotFoundException("BasketItem Not Found");
        }

        BasketItem basketItem= optionalBasketItem.get();

        BasketDTO basketDTO= basketClient.getBasket(basketItem.getBasketId())  ;
        ItemDTO itemDTO= itemClient.getItem(basketItem.getItemId())  ;

        Map<String,Object> data=new HashMap<>();
        data.put("basketItemId",basketItem.getId());
        data.put("basket",basketDTO);
        data.put("item",itemDTO);
        return data;

    }

    @Override
    public BasketItem getById2(Long id) {
        Optional<BasketItem> optionalBasketItem=repository.findById(id);

        if (!optionalBasketItem.isPresent()){

            throw new NotFoundException("BasketItem Not Found");
        }

        BasketItem basketItem= optionalBasketItem.get();
        return basketItem;
    }

    @Override
    public List<BasketItem> getAll() {
        return (List<BasketItem>) repository.findAll();
    }

    @Override
    public List<BasketItem> getAllByBasket(Long basketId) {
        return repository.findAllByBasketId(basketId);
    }

    @Override
    public List<BasketItem> getAllByItem(Long itemId) {
        return repository.findAllByItemId(itemId);
    }


}
