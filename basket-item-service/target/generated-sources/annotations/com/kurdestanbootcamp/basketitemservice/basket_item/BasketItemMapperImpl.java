package com.kurdestanbootcamp.basketitemservice.basket_item;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T14:27:43+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class BasketItemMapperImpl implements BasketItemMapper {

    @Override
    public BasketItem toBasketItem(BasketItemDTO basketItemDTO) {
        if ( basketItemDTO == null ) {
            return null;
        }

        BasketItem basketItem = new BasketItem();

        basketItem.setId( basketItemDTO.getId() );
        basketItem.setVersion( basketItemDTO.getVersion() );
        basketItem.setCreatedDate( basketItemDTO.getCreatedDate() );
        basketItem.setCreatedBy( basketItemDTO.getCreatedBy() );
        basketItem.setLastModifiedDate( basketItemDTO.getLastModifiedDate() );
        basketItem.setLastModifiedBy( basketItemDTO.getLastModifiedBy() );
        basketItem.setCount( basketItemDTO.getCount() );
        basketItem.setBasketId( basketItemDTO.getBasketId() );
        basketItem.setItemId( basketItemDTO.getItemId() );

        return basketItem;
    }

    @Override
    public BasketItemDTO toBasketItemDTO(BasketItem basketItem) {
        if ( basketItem == null ) {
            return null;
        }

        BasketItemDTO basketItemDTO = new BasketItemDTO();

        basketItemDTO.setId( basketItem.getId() );
        basketItemDTO.setVersion( basketItem.getVersion() );
        basketItemDTO.setCreatedDate( basketItem.getCreatedDate() );
        basketItemDTO.setCreatedBy( basketItem.getCreatedBy() );
        basketItemDTO.setLastModifiedDate( basketItem.getLastModifiedDate() );
        basketItemDTO.setLastModifiedBy( basketItem.getLastModifiedBy() );
        basketItemDTO.setCount( basketItem.getCount() );
        basketItemDTO.setBasketId( basketItem.getBasketId() );
        basketItemDTO.setItemId( basketItem.getItemId() );

        return basketItemDTO;
    }

    @Override
    public List<BasketItemDTO> toBasketItemDTOS(List<BasketItem> basketItems) {
        if ( basketItems == null ) {
            return null;
        }

        List<BasketItemDTO> list = new ArrayList<BasketItemDTO>( basketItems.size() );
        for ( BasketItem basketItem : basketItems ) {
            list.add( toBasketItemDTO( basketItem ) );
        }

        return list;
    }

    @Override
    public List<BasketItem> toBasketItems(List<BasketItemDTO> basketItemDTOS) {
        if ( basketItemDTOS == null ) {
            return null;
        }

        List<BasketItem> list = new ArrayList<BasketItem>( basketItemDTOS.size() );
        for ( BasketItemDTO basketItemDTO : basketItemDTOS ) {
            list.add( toBasketItem( basketItemDTO ) );
        }

        return list;
    }
}
