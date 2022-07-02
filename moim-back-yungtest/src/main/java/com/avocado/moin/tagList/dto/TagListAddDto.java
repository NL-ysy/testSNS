package com.avocado.moin.tagList.dto;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.hashtag.domain.Hashtag;
import com.avocado.moin.hashtag.repository.HashtagRepository;
import com.avocado.moin.post.domain.Post;
import com.avocado.moin.post.repository.PostRepository;
import com.avocado.moin.tagList.domain.TagList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Getter
public class TagListAddDto {

    private Long Id;
    private Long postId;
    private Long hashtagId;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private HashtagRepository hashtagRepository;


    public TagList toEntity(){
        return TagList.builder()
                .post(postRepository.findById(postId).get())
                .hashtag(hashtagRepository.findById(hashtagId).get())
                .build();
    }

    public void update(Long postId, Long hashtagId){
        this.postId = postId;
        this.hashtagId = hashtagId;
    }

    @Builder
    public TagListAddDto(Long postId, Long hashtagId) {
        this.postId = postId;
        this.hashtagId = hashtagId;
    }
}
