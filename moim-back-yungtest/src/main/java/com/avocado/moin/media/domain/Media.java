package com.avocado.moin.media.domain;

import com.avocado.moin.post.domain.Post;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
//@CongifurationProperties Annotation=는 자동으로 properties와 POJO class를 연결
//prefix = "file" 로 선언 된 부분은 properties에 선언한 file 필드에 접근한다는 말이다.
@ConfigurationProperties(prefix="file")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "post_id")
    private Post post;
    private String media;

    public void update(String media){
        this.media = media;
    }

    @Builder
    public Media(Post post, String media) {
        this.post = post;
        this.media = media;
    }
    //    public String getUploadMedia() {
//        return media;
//    }

}
