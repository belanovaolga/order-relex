package com.example.orderrelex.dto;

import lombok.*;

/**
 * класс для передачи информации о количестве собранных товаров в микросервис Product
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCountDto {
    private Long productId;
    private Double count;
}
