package com.study.book;

import java.util.Date;

public class Orderspecs {
    public static Specification<Order> orderer(String ordererId) {
        return (root, cb) -> cb.equal(root.get(Order_.orderer).get(Orderer_.memberId).get(MemberId_.id), ordererId);
    }

    public static Specification<Order> between(Date from, Date to) {
        return (root, cb) -> cb.between(root.get(Order_.orderDate), from, to);
    }
}
