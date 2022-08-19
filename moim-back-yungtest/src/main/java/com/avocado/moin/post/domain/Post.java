package com.avocado.moin.post.domain;

import com.avocado.moin.base.UtilTimeSetter;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post extends UtilTimeSetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String url;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime times;
    private String address1;
    private String address2;
    private int headcount;
    private boolean accept;

    public void update(String title, String content, String address1, String address2){
        this.title = title;
        this.content = content;
        this.address1 = address1;
        this.address2 = address2;
    }
    @Builder
    public Post(String title, String content, String address1, String address2) {
        this.title = title;
        this.content = content;
        this.address1 = address1;
        this.address2 = address2;
    }
}