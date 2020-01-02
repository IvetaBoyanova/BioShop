package com.swiftacademy.bioshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@Entity
//@Table(name = "food")
@EqualsAndHashCode(callSuper = false)
@Access(value = AccessType.FIELD)
public class Food extends Product {

    @Column(columnDefinition = "integer default 0")
    private Integer proteins;

    @Column(columnDefinition = "integer default 0")
    private Integer fats;

    @Column(columnDefinition = "integer default 0")
    private Integer carbohydrates;

    @Column(columnDefinition = "integer default 0")
    private Integer fibers;

    public Long getCalories() {
        Long calories = 0L;
        calories += 4 * proteins;
        calories += 4 * carbohydrates;
        calories += 9 * fats;
        calories += 2 * fibers;

        return calories;
    }
}
