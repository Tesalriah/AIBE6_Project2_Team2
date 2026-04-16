package org.article;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Article {
    private int id;
    private String title;
    private String content;
    private LocalDate regDate;

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = LocalDate.now();
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    boolean isNew(){
        return this.id == 0;
    }
}
