package com.avocado.moin.hashtag.domain;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String text;

    public void update(String text) {
        this.text = text;
    }

    @Builder
    public Hashtag(String text) {
        this.text = text;
    }
}