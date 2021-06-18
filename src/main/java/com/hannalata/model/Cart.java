package com.hannalata.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart extends BaseEntity{

    @Column(name = "status")
    private Status status;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @Column(name = "creation_time")
    private Long creationTime;

    public Cart(Integer id, Status status, User user, Long creationTime) {
        super(id);
        this.status = status;
        this.user = user;
        this.creationTime = creationTime;
    }
}
