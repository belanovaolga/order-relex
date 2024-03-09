package com.example.orderrelex.dto;

import com.example.orderrelex.entity.OrderEntity;
import lombok.*;

import java.util.List;

/**
 * класс для получения статистики по собранным товарам
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectedOrderDto {
    List<OrderEntity> collectedList;
}
