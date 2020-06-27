package com.study.book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JpaQueryUtils {
    public static <T> List<Order> toJpaOrders(
            Root<T> root, CriteriaBuilder cb, String... orders) {
        if (orders == null || orders.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.stream(orders)
                .map(orderStr -> toJpaOrders(root, cb, orderStr))
                .collect(toList());
    }

    public static <T> toJpaOrder(Root<T> root, CriteriaBuilder cb, String orderStr) {
        String[] orderClause = orderStr.split(" ");
        boolean ascending = true;
        if (orderClause.length == 2 && orderClause[1].equalsIgnoreCase("desc")) {
            ascending = false;
        }
        String[] paths = orderClause[0].split("\\.");
        Path<Object> path = root.get(paths[0]);
        for (int i = 1; i < paths.length; i++) {
            path = path.get(paths[i]);
        }
        return ascending ? cb.asc(path) : cb.desc(path);
    }

    public static String toJPQLOrderby(String alias, String ... orders) {
        if (orders == null || orders.length == 0) {
            return "";
        }
        String orderParts = Arrays.stream(orders)
                .map(order -> alias + "." + order)
                .collect(joining(","));
        return "order by " + orderParts;
    }
}
