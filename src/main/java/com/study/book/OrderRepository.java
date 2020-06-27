package com.study.book;

import java.util.List;

public class OrderRepository {
    public List<Order> findAll(Specification<Order> spec);
}
