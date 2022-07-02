package com.avocado.moin.comment.domain;

import com.avocado.moin.base.UtilTimeSetter;
import com.avocado.moin.post.domain.Post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends UtilTimeSetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long userId;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;
    private String content;

    public void update(String content){
        this.content = content;
    }

    @Builder
    public Comment(Long userId, Post post, String content) {
        this.userId = userId;
        this.post = post;
        this.content = content;
    }
}

