package front.util;

import java.util.ArrayList;

public class ArticleDB {
    //image 추가 필요
    public int postIdx;
    public int userIdx;
    public String content;
    public ArrayList<CommentDB> comments;

    public ArticleDB(int postIdx, int userIdx, String content, ArrayList<CommentDB> comments){
        this.postIdx = postIdx;
        this.userIdx = userIdx;
        this.content = content;
        this.comments = comments;
    }
}