package com.example.orderrelex.service;

import com.example.orderrelex.dto.CollectedOrderDto;
import com.example.orderrelex.dto.CreateOrderDto;
import com.example.orderrelex.entity.OrderEntity;

import java.time.LocalDate;

public interface OrderService {
    OrderEntity createOrder(CreateOrderDto createOrderDto);

    CollectedOrderDto collectedOrders(LocalDate startDate, LocalDate endDate);

    CollectedOrderDto collectedOrdersByEmployeeId(LocalDate startDate, LocalDate endDate, Long employeeId);
}
