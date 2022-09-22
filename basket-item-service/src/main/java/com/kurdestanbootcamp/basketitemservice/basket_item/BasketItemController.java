package com.kurdestanbootcamp.basketitemservice.basket_item;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/basket-item/")
@AllArgsConstructor
public class BasketItemController {

    private final IBasketItemService basketItemService;
    private BasketItemMapper basketItemMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody BasketItemDTO basketItemDTO){
        BasketItem basketItem =basketItemMapper.toBasketItem(basketItemDTO);
        basketItemService.save(basketItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody BasketItemDTO basketItemDTO){
        BasketItem basketItem =basketItemMapper.toBasketItem(basketItemDTO);
        basketItemService.update(basketItem);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<Map<String,Object>> getById(@PathVariable Long id ){
        return ResponseEntity.ok(basketItemService.getById(id));
    }


    @GetMapping("/v1")
    public ResponseEntity<List<BasketItemDTO>> getAll(){
        List<BasketItem> basketItems= basketItemService.getAll();
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        basketItemService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-basket/{basketId}")
    public ResponseEntity<List<BasketItemDTO>> getAllByBasket(@PathVariable Long basketId){
        List<BasketItem> basketItems= basketItemService.getAllByBasket(basketId);
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }

    @GetMapping("/v1/get-all-by-item/{itemId}")
    public ResponseEntity<List<BasketItemDTO>> getAllByItem(@PathVariable Long itemId){
        List<BasketItem> basketItems= basketItemService.getAllByItem(itemId);
        List<BasketItemDTO> basketItemDTOS = basketItemMapper.toBasketItemDTOS(basketItems);

        return ResponseEntity.ok(basketItemDTOS);
    }
}
