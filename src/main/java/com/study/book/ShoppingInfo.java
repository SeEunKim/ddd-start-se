package com.study.book;

import javax.persistence.*;

@Embeddable
public class ShoppingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="zipCode", column = @Column(name="shipping_zipecode")),
            @AttributeOverride(name="address1", column = @Column(name="shipping_addr1")),
            @AttributeOverride(name="address2", column = @Column(name="shipping_addr2")),
    })
    private Address address;

    @Column(name="shipping_message")
    private String message;

    @Embedded
    private Reciever reciever;
}
