package com.avocado.moin.tagList.domain;

import com.avocado.moin.hashtag.domain.Hashtag;
import com.avocado.moin.post.domain.Post;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class TagList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;

    public void update(Long postId, Long hashtagId) {
        this.post = post;
        this.hashtag = hashtag;
    }

    @Builder
    public TagList(Post post, Hashtag hashtag) {
        this.post = post;
        this.hashtag = hashtag;
    }
}