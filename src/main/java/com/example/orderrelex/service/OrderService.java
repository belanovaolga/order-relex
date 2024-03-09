package com.example.orderrelex.service;

import com.example.orderrelex.dto.CollectedOrderDto;
import com.example.orderrelex.dto.CreateOrderDto;
import com.example.orderrelex.entity.OrderEntity;

public interface OrderService {
    OrderEntity createOrder(CreateOrderDto createOrderDto);

    CollectedOrderDto collectedOrders(String startDate, String endDate);

    CollectedOrderDto collectedOrdersByEmployeeId(String startDate, String endDate, Long employeeId);
}
