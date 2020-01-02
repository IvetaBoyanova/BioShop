package com.swiftacademy.bioshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    CART("Cart"),
    IN_PROCESS("In Progress"),
    ON_HOLD("On Hold"),
    DELIVERING("Delivery"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private String name;

    public static OrderStatus fromValue(String value) {
        for (OrderStatus orderStatus: values()) {
            if (orderStatus.toString().equals(value)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown Order Status %s. Allowed values are: %s",
                value, Arrays.toString(values())));
    }
}
