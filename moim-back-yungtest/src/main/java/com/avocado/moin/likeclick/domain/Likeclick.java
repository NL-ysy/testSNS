package com.avocado.moin.likeclick.domain;

import com.avocado.moin.post.domain.Post;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Likeclick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;
    private Long userId;


    @Builder
    public Likeclick(Post post, Long userId) {
        this.post = post;
        this.userId = userId;
    }
}
