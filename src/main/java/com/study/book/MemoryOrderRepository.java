package com.study.book;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MemoryOrderRepository implements OrderRepository{
    public List<Order> findAll (Specification spec) {
        List<Order> allOrders = findAll();
        return allOrders.stream().filter(order -> spec.isSatisfedBy(order)).collect(toList());
    }
}
