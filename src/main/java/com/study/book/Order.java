package com.study.book;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "purchase_order")
public class Order {
// 주문 애그리거트의 루트 엔티티인 Order로 @Entity 매핑
    @Embedded
    private Orderer orderer;

    @Embedded
    private ShoppingInfo shippingInfo;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private OrderState state;
}
