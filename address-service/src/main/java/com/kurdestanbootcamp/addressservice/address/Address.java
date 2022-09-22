package com.kurdestanbootcamp.addressservice.address;

import com.kurdestanbootcamp.addressservice.common.BaseEntity;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_address")
@Data
@Audited
public class Address extends BaseEntity {

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

}