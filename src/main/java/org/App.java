package org;

import org.article.ArticleController;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    App(){
        this.sc = AppContext.scanner;
    }

    void run(){

        ArticleController articleController = new ArticleController(sc);
        while (true){

            System.out.print("명령어: ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName()){
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case "write" -> {
                    articleController.actionWrite();
                }
                case "list" -> {
                    articleController.actionList();
                }
                case "detail" -> {
                    articleController.actionDetail(rq);
                }
                case "update" -> {
                    articleController.actionUpdate(rq);
                }
                case "delete" -> {
                    articleController.actionDelete(rq);
                }
            }
        }
    }
}
