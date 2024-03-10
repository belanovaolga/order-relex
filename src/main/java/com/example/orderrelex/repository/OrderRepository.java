package com.example.orderrelex.repository;

import com.example.orderrelex.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByCreateTimeAfterAndCreateTimeBefore(LocalDate startDate, LocalDate endDate);

    List<OrderEntity> findAllByEmployeeIdAndCreateTimeAfterAndCreateTimeBefore(
            Long employeeId,
            LocalDate startDate,
            LocalDate endDate);
}
