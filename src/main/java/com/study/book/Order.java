package com.study.book;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId
    private OrderNo number;

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

    @ElementCollection
    @CollectionTable(name = "order_line",
                        joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Column(name = "emails")
    @Convert(converter = EmailSetConverter.class)
    private EmailSet emailSet;


}
