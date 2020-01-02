package com.swiftacademy.bioshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String city;

    @Column(name = "post_code")
    private Integer postCode;

    @Column
    private String street;

    @Column(name = "is_primary_address")
    private String isPrimaryAddress;

    @Column(name = "is_billing_address")
    private String isBillingAddress;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
