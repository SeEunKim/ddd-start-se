package com.study.book;

import javax.persistence.Column;

public class Product {
    @Column(name="WIDTH")
    private String width;

    public Length getWidth(){
        return new Width(width);
        // DB 칼럼 값을 실제 프로퍼티 타입으로 변환
    }

    void setWidth(Length width) {
        this.width = width.toString();
        // 실제 프로퍼티 타입을 DB 컬럼 값으로 변환
    }
}
