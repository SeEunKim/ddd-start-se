package com.study.book;

import javax.persistence.*;

@Embeddable
public class Orderer {
    //Order에 속하는 밸류이므로 @Enbeddable로 매핑

    //MemberId에 정의된 칼럼 이름을 변경하기 위해
    // @AttributeOeverried 애노테이션 사용
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name="id", column=@Column(name="orderer_id"))
    )
    private MemberId memberId;

    @Column(name="orderer_name")
    private String name;


}
