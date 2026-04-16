package org.article;

import org.AppContext;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(){
        articleRepository = AppContext.articleRepository;
    }

    public Article write(String title, String contents){
        Article article = new Article(title, contents);
        return articleRepository.save(article);
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public void update(Article article){
        articleRepository.save(article);
    }

    public int remove(int id) {
        return articleRepository.remove(id);
    }
}
