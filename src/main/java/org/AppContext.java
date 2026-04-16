package org;

import org.article.ArticleController;
import org.article.ArticleRepository;
import org.article.ArticleService;

import java.util.Scanner;

public class
AppContext {
    public static Scanner scanner;
    public static ArticleController articleController;
    public static ArticleService articleService;
    public static ArticleRepository articleRepository;

    public static void renew(Scanner sc) {
        scanner = sc;
        articleRepository = new ArticleRepository();
        articleService = new ArticleService();
        articleController = new ArticleController(sc);
    }
    public static void renew() {
        Scanner scanner = new Scanner(System.in);
        renew(scanner);
    }
}
