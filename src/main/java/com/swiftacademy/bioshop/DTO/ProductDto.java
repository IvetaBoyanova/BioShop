package com.swiftacademy.bioshop.DTO;

import com.swiftacademy.bioshop.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private Byte[] image;
    private String name;
    private Double price;
    private Category category;
    private Integer quantity;
}
