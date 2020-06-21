package com.study.book;

import org.graalvm.compiler.api.replacements.ClassSubstitution;

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

    @Column(name ="total_amounts")
    private Money totalAmounts; // MoneyConverter를 적용해서 값 변환
//
//    @Column(name="total_amounts")
//    @Convert(converter = MoneyConverter.class)
//    private Money totalAmounts;


}
