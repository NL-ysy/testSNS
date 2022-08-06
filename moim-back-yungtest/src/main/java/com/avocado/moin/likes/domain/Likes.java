package com.avocado.moin.likes.domain;
import com.avocado.moin.post.domain.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
//@Table(
//        uniqueConstraints = {
//                @UniqueConstraint(
//                        name="likes_uk",
//                        columnNames = {"post_id", "user_id"}
//                )
//        }
//)
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private String postImgUrl;
//    private String post;

    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post post;

//    @JsonIgnoreProperties({"postList"}) //post -> user -> likesList -> user -> postList 무한 참조 막기 위함
//    @JoinColumn(name = "user_id")
//    @ManyToOne
//    private User user;

    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post")
    private List<Likes> likesList;

    @Transient
    private long likesCount;

    @Transient
    private boolean likesState;

    public void updateLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public void updateLikesState(boolean likesState) {
        this.likesState = likesState;
    }

    @Builder
    public Likes(Post post, String postImgUrl, long likesCount) {
        this.post = post;
        this.postImgUrl = postImgUrl;
        this.likesCount = likesCount;
//        this.user = user;
    }
}
