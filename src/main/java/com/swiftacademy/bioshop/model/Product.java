package com.swiftacademy.bioshop.model;

import com.swiftacademy.bioshop.enums.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column
    private Double price;

    @Lob
    @Column(name = "product_image", nullable = false, columnDefinition = "mediumblob")
    private Byte[] image;

    @Column
    private Integer quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private Vendor vendor;

}
