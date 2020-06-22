package com.study.book;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderLine {
    @Embedded
    private ProdectId prodectId;

    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private Money amounts;
}
