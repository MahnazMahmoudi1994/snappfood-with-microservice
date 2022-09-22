package com.kurdestanbootcamp.itemservice.item;

import com.kurdestanbootcamp.itemservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
public class ItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = false,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private Double price;

    @ApiModelProperty(required = false,hidden = false)
    private String image;

    @ApiModelProperty(required = true,hidden = false)
    private Long supplierCategoryId;


}
