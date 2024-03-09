package com.example.orderrelex.dto;

import lombok.*;

/**
 * класс для ввода информации по собранным товарам
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDto {
    private Long employeeId;
    private Long productId;
    private Double count;
}
