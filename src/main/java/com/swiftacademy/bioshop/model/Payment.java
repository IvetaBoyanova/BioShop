package com.swiftacademy.bioshop.model;

import com.swiftacademy.bioshop.enums.PaymentType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "date_of_payment")
    private Date dateOfPayment;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
