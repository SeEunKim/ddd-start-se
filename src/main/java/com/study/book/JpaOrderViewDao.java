package com.study.book;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaOrderViewDao implements OrderViewDao {
    @PersistenceContext
    private EntityManager em;

    public List<OrderView> selectByOrderer(String ordererId) {
        String selectQuery =
                "select new OrderView(o, m, p)" +
                        "from Order o join o.orderLine o1, Member m Product p " +
                        "where o.orderer.memberId. id = :ordererId" +
                        "and index(o1) = 0" +
                        "and o1.productID = p.id "+
                        "order by o.number.number desc";
        TypedQuery<OrderView> query = em.createQuery(selectQuery, OrderView.class);
        query.setParameter("ordererId", ordererId);
        return query.getResultList();
    }
}
