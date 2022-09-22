package com.kurdestanbootcamp.userservice.user;

import com.kurdestanbootcamp.userservice.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

}