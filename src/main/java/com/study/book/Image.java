package com.study.book;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Table(name = "image")
public abstract class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_type")
    private String imageType;
    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;


    protected Image() {}
    public Image(String path) {
        this.path = path;
        this.uploadTime = new Date();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public abstract String getURL();
    public abstract boolean hasThumbname();
    public abstract String getThumbnailURL();

    public boolean hasThumbnail() {
        // 성능을 위해 다형을 포기하고 if-else로 구현
        if (imageType.equals("IT")) {
            return true;
        } else {
            return false;
        }
    }
}
