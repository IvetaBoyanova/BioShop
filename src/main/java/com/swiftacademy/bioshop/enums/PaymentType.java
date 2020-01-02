package com.swiftacademy.bioshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PaymentType {
    ONLINE("online"),
    ON_DELIVERY("on delivery");

    private String name;

    public static PaymentType fromValue(String value) {
        for (PaymentType paymentType: values()) {
            if (paymentType.toString().equals(value)) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown Payment Type %s. Allowed values are: %s",
                value, Arrays.toString(values())));
    }
}
