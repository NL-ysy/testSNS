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
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime times;
    private String location1;
    private String location2;

    public void update(String title, String content, String location1, String location2){
        this.title = title;
        this.content = content;
        this.location1 = location1;
        this.location2 = location2;
    }
    @Builder
    public Post(String title, String content, String location1, String location2) {
        this.title = title;
        this.content = content;
        this.location1 = location1;
        this.location2 = location2;
    }
}