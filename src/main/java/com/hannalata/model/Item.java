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
@Table(name = "items")
public class Item extends BaseEntity{

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "availability")
    private Integer availability;

    public Item(Integer id, String code, String name, Integer price, Integer availability) {
        super(id);
        this.code = code;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }
}
