package com.kurdestanbootcamp.basketservice.basket;

import com.kurdestanbootcamp.basketservice.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/basket/")
@AllArgsConstructor
public class BasketController {

    private final IBasketService basketService;
    private BasketMapper basketMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody BasketDTO basketDTO){
        Basket basket =basketMapper.toBasket(basketDTO);
        basketService.save(basket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody BasketDTO basketDTO){
        Basket basket =basketMapper.toBasket(basketDTO);
        basketService.update(basket);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<BasketDTO> getById(@PathVariable Long id ){
        Basket basket = basketService.getById(id);
        BasketDTO basketDTO =basketMapper.toBasketDTO(basket);
        return ResponseEntity.ok(basketDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<BasketDTO>> getAll(){
        List<Basket> baskets= basketService.getAll();
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOS(baskets);

        return ResponseEntity.ok(basketDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        basketService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-address/{addressId}")
    public ResponseEntity<List<BasketDTO>> getAllByAddress(@PathVariable Long addressId){
        List<Basket> baskets= basketService.getAllByAddress(addressId);
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOS(baskets);

        return ResponseEntity.ok(basketDTOS);
    }

    @GetMapping("/v1/get-all-by-supplier/{supplierId}")
    public ResponseEntity<List<BasketDTO>> getAllBySupplier(@PathVariable Long supplierId){
        List<Basket> baskets= basketService.getAllBySupplier(supplierId);
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOS(baskets);

        return ResponseEntity.ok(basketDTOS);
    }


    @GetMapping("/v1/get-all-by-status/{status}")
    public ResponseEntity<List<BasketDTO>> getAllByStatus(@PathVariable Boolean status){
        List<Basket> baskets= basketService.getAllByStatus(status);
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOS(baskets);

        return ResponseEntity.ok(basketDTOS);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<BasketDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<Basket> basketPage= basketService.paging(page,size);

        int totalPage =  basketPage.getTotalPages();
        List<Basket> data = basketPage.getContent();
        List<BasketDTO> basketDTOS = basketMapper.toBasketDTOS(data);

        PagingData<BasketDTO> pagingData = new PagingData<>(totalPage,page,basketDTOS);

        return ResponseEntity.ok(pagingData);
    }

}
