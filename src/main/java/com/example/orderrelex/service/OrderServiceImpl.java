package com.example.orderrelex.service;

import com.example.orderrelex.dto.CollectedOrderDto;
import com.example.orderrelex.dto.CreateOrderDto;
import com.example.orderrelex.dto.ProductCountDto;
import com.example.orderrelex.entity.OrderEntity;
import com.example.orderrelex.repository.OrderRepository;
import com.example.orderrelex.rest.RestConsumerProductImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final RestConsumerProductImpl restConsumerProductImpl;
    @Override
    public OrderEntity createOrder(CreateOrderDto createOrderDto) {
        OrderEntity order = OrderEntity
                .builder()
                .employeeId(createOrderDto.getEmployeeId())
                .productId(createOrderDto.getProductId())
                .count(createOrderDto.getCount())
                .createTime(LocalDate.now())
                .build();

        orderRepository.save(order);

        ProductCountDto product = ProductCountDto
                .builder()
                .productId(createOrderDto.getProductId())
                .count(createOrderDto.getCount())
                .build();

        restConsumerProductImpl.setProductCount(product);

        return order;
    }

    @Override
    public CollectedOrderDto collectedOrders(String startDate, String endDate) {
        List<OrderEntity> addProductList = new ArrayList<>();

        for(OrderEntity order : orderRepository.findAll()) {
            if(order.getCreateTime().isAfter(LocalDate.parse(startDate))
                    && order.getCreateTime().isBefore(LocalDate.parse(endDate))) {
                addProductList.add(order);
            }
        }

        return new CollectedOrderDto(addProductList);
    }

    @Override
    public CollectedOrderDto collectedOrdersByEmployeeId(String startDate, String endDate, Long employeeId) {
        List<OrderEntity> addProductList = new ArrayList<>();

        for(OrderEntity order : orderRepository.findAllByEmployeeId(employeeId)) {
            if(order.getCreateTime().isAfter(LocalDate.parse(startDate))
                    && order.getCreateTime().isBefore(LocalDate.parse(endDate))) {
                addProductList.add(order);
            }
        }

        return new CollectedOrderDto(addProductList);
    }
}
