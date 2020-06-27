package com.study.book;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class Service {
    public void searchOrder() {
        Specification<Order> ordererSpec = new OrdererSpec("madvires");
        List<Order> orders = orderRepository.findAll(ordererSpec);

        Specification<Order> orderSpec1 = new OrdererSpec("mad");
        Specification<Order> orderDateSpec = new OrdererSpec(fromDate, toDate);
        AndSpec<T> spec = new AndSpec<T>(ordererSpec, orderDateSpec);
        List<Order> orders = orderRepository.findAll(spec);

        Specification<Order> betweenSpec = Orderspecs.between(fromTime, toTime);

        Specification<Order> specs = Specs.and(Orderspecs.orderer("madvirus"), Orderspecs.between(fromTime, toTime));



    }
}
