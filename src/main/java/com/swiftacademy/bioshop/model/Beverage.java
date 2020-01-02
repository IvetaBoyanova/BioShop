package com.swiftacademy.bioshop.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "beverage")
@EqualsAndHashCode(callSuper = false)
@Access(value = AccessType.FIELD)
public class Beverage extends Product {

    @Column(name = "percent_alcohol")
    private String percentAlcohol;

}
