package com.study.book;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;

    public boolean is2ndGeneration() {
        return number.startsWith("N");
    }
}
