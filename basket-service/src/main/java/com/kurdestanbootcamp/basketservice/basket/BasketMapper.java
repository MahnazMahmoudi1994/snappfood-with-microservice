package com.kurdestanbootcamp.basketservice.basket;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    Basket toBasket(BasketDTO basketDTO);

    BasketDTO toBasketDTO(Basket basket);

    List<BasketDTO> toBasketDTOS(List<Basket> baskets);

    List<Basket> toBaskets(List<BasketDTO> basketDTOS);

}
