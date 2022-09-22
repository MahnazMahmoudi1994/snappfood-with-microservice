package com.kurdestanbootcamp.basketitemservice.basket_client;

import com.kurdestanbootcamp.basketitemservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class BasketDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private Double paidPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean status;


}
