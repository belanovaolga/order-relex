package com.example.orderrelex.service;

import com.example.orderrelex.dto.CollectedOrderDto;
import com.example.orderrelex.dto.CreateOrderDto;
import com.example.orderrelex.dto.ProductCountDto;
import com.example.orderrelex.entity.OrderEntity;
import com.example.orderrelex.repository.OrderRepository;
import com.example.orderrelex.rest.RestConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final RestConsumer restConsumer;
    @Override
    public OrderEntity createOrder(CreateOrderDto createOrderDto) {
        OrderEntity order = OrderEntity
                .builder()
                .employeeId(createOrderDto.getEmployeeId())
                .productId(createOrderDto.getProductId())
                .count(createOrderDto.getCount())
                .createTime(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        ProductCountDto product = ProductCountDto
                .builder()
                .productId(createOrderDto.getProductId())
                .count(createOrderDto.getCount())
                .build();

        restConsumer.setProductCount(product);

        return order;
    }

    @Override
    public CollectedOrderDto collectedOrders(String startDate, String endDate) {
        List<OrderEntity> addProductList = new ArrayList<>();

        for(OrderEntity order : orderRepository.findAll()) {
            if(order.getCreateTime().isAfter(periodDate(startDate)) && order.getCreateTime().isBefore(periodDate(endDate))) {
                addProductList.add(order);
            }
        }

        return new CollectedOrderDto(addProductList);
    }

    @Override
    public CollectedOrderDto collectedOrdersByEmployeeId(String startDate, String endDate, Long employeeId) {
        List<OrderEntity> addProductList = new ArrayList<>();

        for(OrderEntity order : orderRepository.findAllByEmployeeId(employeeId)) {
            if(order.getCreateTime().isAfter(periodDate(startDate)) && order.getCreateTime().isBefore(periodDate(endDate))) {
                addProductList.add(order);
            }
        }

        return new CollectedOrderDto(addProductList);
    }

    /**
     * перевод введенной даты в удобный для обработки формат
     * @param periodDate дата в формате String
     * @return дата в формате LocalDateTime
     */
    private LocalDateTime periodDate(String periodDate) {
        String[] dateList = periodDate.split("\\.");

        LocalDate datePeriod = LocalDate.of(
                Integer.parseInt(dateList[2]),
                Integer.parseInt(dateList[1]),
                Integer.parseInt(dateList[0])
        );

        return datePeriod.atStartOfDay();
    }
}
