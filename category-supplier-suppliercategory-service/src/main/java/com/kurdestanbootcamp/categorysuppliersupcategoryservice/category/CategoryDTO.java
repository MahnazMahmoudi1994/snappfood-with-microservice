package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class CategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String logo;


}
