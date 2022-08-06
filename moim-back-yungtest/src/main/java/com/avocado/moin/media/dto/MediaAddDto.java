package com.avocado.moin.media.dto;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.media.domain.Media;
import com.avocado.moin.post.repository.PostRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
public class MediaAddDto {

    private Long id;
    private Long postId;
    private String media;

    @Autowired
    private PostRepository postRepository;

    public Media toEntity(){
        return Media.builder()
                .post(postRepository.findById(postId).get())
                .media(media)
                .build();
    }

    @Builder
    public MediaAddDto(Long postId, String media) {
        this.postId = postId;
        this.media = media;
    }
}
