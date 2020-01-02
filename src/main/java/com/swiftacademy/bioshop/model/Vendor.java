package com.swiftacademy.bioshop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column(columnDefinition = "text")
    private String description;
}
