package com.kurdestanbootcamp.basketitemservice.basket_client;

import com.kurdestanbootcamp.basketitemservice.common.config.FeignConfig;
import com.kurdestanbootcamp.basketitemservice.item_client.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "basket", url = "http://localhost:8080/basketservice/basket", configuration = FeignConfig.class)

public interface BasketClient {

    @GetMapping(value = "/v1/{basketId}")
    BasketDTO getBasket(@PathVariable(value = "basketId") Long basketId);
}