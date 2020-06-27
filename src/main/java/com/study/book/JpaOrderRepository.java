package com.study.book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Predicate;

public class JpaOrderRepository implements OrderRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll(Specification<Order> spec, String ... orders) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class);
        Root<Order> root = criteriaQuery.from(Order.class);
        Predicate predicate = spec.toPredicate(root, cb);
        criteriaQuery.where(predicate);
        if (orders.length > 0) {
            criteriaQuery.orderBy(
                   JpaQueryUtils.toJpaOrders(root, cb, orders));

        }

        TypedQuery<Order> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
        TypedQuery<Order> query = entityManager.createQuery(
                "select o from Order o" +
                        "where o.orderer.memberId.id = :ordererId " +
                        "order by o.number.number desc"), Order.class);

        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);
        return query.getResultList();
    }

    public Long countsAll() {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(o) from Order o", Long.class);
        return query.getSingleResult();
    }

    public Long counts(Specification<Order> spec) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
        Root<Order> root = criteriaQuery.from(Order.class);
        criteriaQuery.select(cb.count(root)).where(spec.toPredicate(root, cb));
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }



}
