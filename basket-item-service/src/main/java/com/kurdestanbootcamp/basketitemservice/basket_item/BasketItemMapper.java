package com.kurdestanbootcamp.basketitemservice.basket_item;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketItemMapper {

    BasketItem toBasketItem(BasketItemDTO basketItemDTO);

    BasketItemDTO toBasketItemDTO(BasketItem basketItem);

    List<BasketItemDTO> toBasketItemDTOS(List<BasketItem> basketItems);

    List<BasketItem> toBasketItems(List<BasketItemDTO> basketItemDTOS);

}
