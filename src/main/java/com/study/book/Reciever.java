package com.study.book;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Reciever {
    @Column(name="receiver_name")
    private String name;
    @Column(name="receiver_phone")
    private String phone;

    // JPA를 적용하기 위해 기본 생성자 추가
    // 기본 생성자는 JPA 프로바이더가 객체를 생성할 때만 사용한다. 다른 코드에서 사용하지 못하도록 protected로 선언
    protected Reciever() {
    }

    public Reciever(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


}
