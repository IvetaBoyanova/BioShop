package com.swiftacademy.bioshop.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Category {
    VITAMIN("Vitamin"),
    NUT("Nut"),
    FOOD("Food"),
    DRINK("Drink");

    private String name;

    public static Category fromValue(String value) {
        for (Category category : values()) {
            if (category.toString().equals(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown Category %s. Allowed categories are: %s",
                value, Arrays.toString(values())));
    }
}
