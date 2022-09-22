package com.kurdestanbootcamp.addressservice.address;


import com.kurdestanbootcamp.addressservice.common.BaseDTO;
import com.kurdestanbootcamp.addressservice.common.LocationDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = false,hidden = false)
    private String details;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private Long userId;
}
