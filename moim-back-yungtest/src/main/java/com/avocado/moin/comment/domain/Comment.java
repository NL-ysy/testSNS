package com.avocado.moin.comment.domain;

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
public class Comment extends UtilTimeSetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long userId;
    private Long postId;
    private String content;

    public void update(String content){
        this.content = content;
    }

    @Builder
    public Comment(Long userId, Long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }
}

