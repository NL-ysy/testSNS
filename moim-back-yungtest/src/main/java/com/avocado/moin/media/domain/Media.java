package com.avocado.moin.media.domain;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Long postId;
    private String media;

    public String getUploadMedia() {
        return media;
    }

}
