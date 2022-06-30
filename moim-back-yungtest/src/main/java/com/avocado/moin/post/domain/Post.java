package com.avocado.moin.post.domain;

import com.avocado.moin.base.UtilTimeSetter;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Post extends UtilTimeSetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long userId;
    private String title;
    private String content;
    private String location;

    public void update(String title, String content, String location){
        this.title = title;
        this.content = content;
        this.location = location;
    }
    @Builder
    public Post(String title, String content, String location) {
        this.title = title;
        this.content = content;
        this.location = location;
    }
}