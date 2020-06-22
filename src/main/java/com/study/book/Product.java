package com.study.book;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
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

    @EmbeddedId
    private ProductId id;
    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money private;
    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_liune",
                        joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @OrderColumn(name = "list_idx")

    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
