package front.util;

import java.util.ArrayList;

/**
 * 데모 파일. 테스트용
 */
public class DBDemo {
    public static void printArticle(ArticleDB article){
        System.out.println("----------Post---------");
        System.out.println("postIdx: " + article.postIdx);
        System.out.println("content: " + article.content);
        System.out.println("userIdx: " + article.userIdx);
        System.out.println("--------Comments-------");
        for (CommentDB comment : article.comments){;
            System.out.println("content: " + comment.content);
            System.out.println("commentIdx: " + comment.commentIdx);
            System.out.println("postIdx: " + comment.postIdx);
            System.out.println("userIdx: " + comment.userIdx);
            System.out.println();
        }
    }

    public static void main(String[] args){
        ArticleDBManager manager = new ArticleDBManager();
        ArrayList<ArticleDB> articles;
        articles = manager.getArticleList();

        for (ArticleDB article : articles){
            printArticle(article);
        }

        for (int i = 0; i < 3; i++) {
            manager.addComment("추가된 메세지" + i, articles.get(i));
        }
    }
}