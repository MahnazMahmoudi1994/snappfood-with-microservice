package com.kurdestanbootcamp.itemservice.item;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {


    Item toItem(ItemDTO itemDTO);

    ItemDTO toItemDTO(Item item);

    List<ItemDTO> toItemDTOS(List<Item> items);

    List<Item> toItems(List<ItemDTO> itemDTOS);


}
