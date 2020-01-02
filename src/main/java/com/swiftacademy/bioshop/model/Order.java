package com.swiftacademy.bioshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swiftacademy.bioshop.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ordered_date")
    private Date orderedDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id")
    private Address deliveryAddress;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    @JsonIgnore
    public Double getTotalPrice() {
        return items.stream().map(Item::getTotalQuantityPrice).reduce(Double::sum).orElse(0D);
    }
}
