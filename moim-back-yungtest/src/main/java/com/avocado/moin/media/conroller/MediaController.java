package com.avocado.moin.media.conroller;

import com.avocado.moin.comment.domain.Comment;
import com.avocado.moin.comment.dto.CommentAddDto;
import com.avocado.moin.comment.dto.CommentUpdateDto;
import com.avocado.moin.media.domain.Media;
import com.avocado.moin.media.dto.MediaAddDto;
import com.avocado.moin.media.repository.MediaRepository;
import com.avocado.moin.media.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/media")
    public void saveMedia(@RequestBody MediaAddDto mediaAddDto){
        mediaService.addMedia(mediaAddDto);
    }

    @PutMapping("/media/{id}")
    public void editMedia(@PathVariable Long id, @RequestBody MediaAddDto mediaAddDto){
        mediaService.editMedia(id, mediaAddDto);
    }

    @GetMapping("/media")
    public List<Media> findAllMedia(){
        return mediaService.findAllMedia();
    }

    @DeleteMapping("/Media/{id}")
    public void delMedia(@PathVariable Long id) {mediaService.delMedia(id);}
}
