package com.kurdestanbootcamp.basketitemservice.basket_item;

import com.kurdestanbootcamp.basketitemservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BasketItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Integer count;

    @ApiModelProperty(required = true,hidden = false)
    private Long basketId;

    @ApiModelProperty(required = true,hidden = false)
    private Long itemId;


}
