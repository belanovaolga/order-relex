package com.example.orderrelex.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * класс для добавления собранных товаров в базу данных
 */
@Entity
@Table(name = "order_product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "product_id")
    private Long productId;
    private Double count;

    @Column(name = "create_time")

    private LocalDate createTime;
}
