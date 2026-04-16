package org.article;

import org.AppContext;
import org.Rq;

import java.util.List;
import java.util.Scanner;

public class ArticleController {
    private final Scanner sc;
    private final ArticleService articleService;

    public ArticleController(Scanner scanner){
        this.sc = scanner;
        this.articleService = AppContext.articleService;
    }


    public void actionWrite(){
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String contents = sc.nextLine();

        Article article = articleService.write(title, contents);
        if(article != null){
            System.out.println("=>게시글이 등록되었습니다.");
        }
    }

    public void actionList(){
        System.out.println("번호 | 제목      | 등록일");
        System.out.println("----------------------------------");
        List<Article> list = articleService.findAll();
        for(Article article : list){
            System.out.println("%s    | %s      | %s".formatted(article.getId(),article.getTitle(),article.getRegDate()));
        }
    }

    public void actionDetail(Rq rq){
        int id = rq.getId();
        Article article = articleService.findById(id);
        if(article.getId() == rq.getId()){
            System.out.println("번호 : %d".formatted(article.getId()));
            System.out.println("제목 : %s".formatted(article.getTitle()));
            System.out.println("내용 : %s".formatted(article.getContent()));
            System.out.println("등록일 : %s".formatted(article.getRegDate()));
        }
    }

    public void actionUpdate(Rq rq){
        int id = rq.getId();
        Article article = articleService.findById(id);
        if(article != null){
            System.out.println("제목 (현재 :"+ article.getTitle() +"): ");
            String title = sc.nextLine();
            System.out.println("내용 (현재 :"+ article.getContent() +"): ");
            String contents = sc.nextLine();
            System.out.println("=> 게시글이 수정되었습니다.");
            articleService.update(new Article(id, title, contents));
        }else{
            System.out.println(rq.getId()+"번 명언은 존재하지 않습니다.");
        }
    }

    public void actionDelete(Rq rq){
        int id = rq.getId();
        if(articleService.remove(id) == 1){
            System.out.println("=> 게시글이 삭제되었습니다.");
        }
    }
}
