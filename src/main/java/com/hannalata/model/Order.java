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
@Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne(targetEntity = Item.class)
    private Item item;
    @ManyToOne(targetEntity = Cart.class)
    private Cart cart;
    @Column(name = "amount")
    private Integer amount;

    public Order(Integer id, Item item, Cart cart, Integer amount) {
        super(id);
        this.item = item;
        this.cart = cart;
        this.amount = amount;
    }
}
