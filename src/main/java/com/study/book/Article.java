package com.study.book;

import javax.persistence.*;

@Entity
@Table(name = "articel")
@SecondaryTable(
        name= "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {
    @Id
    private Long id;
    private String title;

    @AttributeOverride(column = {
            @AttributeOverride(name = "content",
                    column = @Column(table = "article_content")),
            @AttributeOverride(name = "contentType",
                    column = @Column(table = "article_content"))
    })

    private ArticelContent content;
}
