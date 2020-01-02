package com.swiftacademy.bioshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, name = "singular_price")
    private Double singularPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @JsonIgnore
    public Double getTotalQuantityPrice() {
        return quantity * singularPrice;
    }
}
