package com.kurdestanbootcamp.basketservice.common;

import lombok.Data;

@Data
public class LocationDTO {
    private Double lng;
    private Double lat;

    @Override
    public String toString() {
        return "LocationDTO{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}