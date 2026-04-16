package org.article;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private int lastId = 0;
    private final List<Article> list = new ArrayList<>();

    public Article save(Article article){
        article.setRegDate(LocalDate.now());
        if(article.isNew()){
            article.setId(++lastId);
            list.add(article);
        }else{
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getId() == article.getId()){
                    list.set(i, article);
                    break;
                }
            }
        }

        return article;
    }

    public List<Article> findAll(){
        return list.reversed();
    }


    public Article findById(int id) {
        for(Article article : list){
            if(id == article.getId()){
                return article;
            }
        }
        return null;
    }

    public int remove(int id) {
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getId() == id){
                list.remove(list.get(i));
                return 1;
            }
        }
        return 0;
    }
}
