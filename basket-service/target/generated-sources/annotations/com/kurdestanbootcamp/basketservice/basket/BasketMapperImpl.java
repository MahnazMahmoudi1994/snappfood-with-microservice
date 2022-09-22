package com.kurdestanbootcamp.basketservice.basket;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-21T13:38:39+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Override
    public Basket toBasket(BasketDTO basketDTO) {
        if ( basketDTO == null ) {
            return null;
        }

        Basket basket = new Basket();

        basket.setId( basketDTO.getId() );
        basket.setVersion( basketDTO.getVersion() );
        basket.setCreatedDate( basketDTO.getCreatedDate() );
        basket.setCreatedBy( basketDTO.getCreatedBy() );
        basket.setLastModifiedDate( basketDTO.getLastModifiedDate() );
        basket.setLastModifiedBy( basketDTO.getLastModifiedBy() );
        basket.setPaidPrice( basketDTO.getPaidPrice() );
        basket.setStatus( basketDTO.getStatus() );
        basket.setAddressId( basketDTO.getAddressId() );
        basket.setSupplierId( basketDTO.getSupplierId() );

        return basket;
    }

    @Override
    public BasketDTO toBasketDTO(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        BasketDTO basketDTO = new BasketDTO();

        basketDTO.setId( basket.getId() );
        basketDTO.setVersion( basket.getVersion() );
        basketDTO.setCreatedDate( basket.getCreatedDate() );
        basketDTO.setCreatedBy( basket.getCreatedBy() );
        basketDTO.setLastModifiedDate( basket.getLastModifiedDate() );
        basketDTO.setLastModifiedBy( basket.getLastModifiedBy() );
        basketDTO.setPaidPrice( basket.getPaidPrice() );
        basketDTO.setStatus( basket.getStatus() );
        basketDTO.setAddressId( basket.getAddressId() );
        basketDTO.setSupplierId( basket.getSupplierId() );

        return basketDTO;
    }

    @Override
    public List<BasketDTO> toBasketDTOS(List<Basket> baskets) {
        if ( baskets == null ) {
            return null;
        }

        List<BasketDTO> list = new ArrayList<BasketDTO>( baskets.size() );
        for ( Basket basket : baskets ) {
            list.add( toBasketDTO( basket ) );
        }

        return list;
    }

    @Override
    public List<Basket> toBaskets(List<BasketDTO> basketDTOS) {
        if ( basketDTOS == null ) {
            return null;
        }

        List<Basket> list = new ArrayList<Basket>( basketDTOS.size() );
        for ( BasketDTO basketDTO : basketDTOS ) {
            list.add( toBasket( basketDTO ) );
        }

        return list;
    }
}
