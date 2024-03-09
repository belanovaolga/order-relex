package com.example.orderrelex.controller;

import com.example.orderrelex.dto.CollectedOrderDto;
import com.example.orderrelex.dto.CreateOrderDto;
import com.example.orderrelex.entity.OrderEntity;
import com.example.orderrelex.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    /**
     * добавление сотрудниками собранных товаров в базу данных и передача этих данных в микросервис Product
     * @param createOrderDto данные, необходимые для отражения собранного сотрудником товара
     *                       и изменения количества товара в базе данных (
     *                       идентификационный номер сотрудника,
     *                       идентификационный номер товара,
     *                       количество собранного товара)
     * @return данные о добавлении товара
     */
    @PostMapping("/createOrder")
    public OrderEntity createOrder(
            @RequestBody CreateOrderDto createOrderDto
            ) {
        return orderService.createOrder(createOrderDto);
    }

    /**
     * получение статистики по собранным товарам за конкретный период времени по всей ферме в целом
     * @param startDate начальная дата отсчета (невкл.), напр., 1.03.2024
     * @param endDate конечная дата (невкл.), напр., 10.03.2024
     * @return все товары, собранные за период времени, в данном случае с 2.03.2024 по 9.03.2024 (вкл.)
     */
    @GetMapping("/collectedOrders/{startDate}/{endDate}")
    public CollectedOrderDto collectedOrders(
            @PathVariable String startDate,
            @PathVariable String endDate
    ) {
        return orderService.collectedOrders(startDate, endDate);
    }

    /**
     * получение статистики по собранным товарам за конкретный период времени по конкретному сотруднику
     * @param startDate начальная дата отсчета (невкл.), напр., 1.03.2024
     * @param endDate конечная дата (невкл.), напр., 10.03.2024
     * @param employeeId идентификационный номер сотрудника
     * @return все товары, собранные конкретным сотрудником за период времени,
     * в данном случае с 2.03.2024 по 9.03.2024 (вкл.)
     */
    @GetMapping("/collectedOrders/{startDate}/{endDate}/{employeeId}")
    public CollectedOrderDto collectedOrdersByEmployeeId(
            @PathVariable String startDate,
            @PathVariable String endDate,
            @PathVariable Long employeeId
    ) {
        return orderService.collectedOrdersByEmployeeId(startDate, endDate, employeeId);
    }

}
