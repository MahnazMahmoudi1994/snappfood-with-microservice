package com.kurdestanbootcamp.basketservice.basket;

import com.kurdestanbootcamp.basketservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class BasketDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private Double paidPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean status;

    @ApiModelProperty(required = true,hidden = false)
    private Long addressId;

    @ApiModelProperty(required = true,hidden = false)
    private Long supplierId;
}
