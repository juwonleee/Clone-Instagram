package front.util;

public class CommentDB {
    public int commentIdx;
    public int userIdx;
    public int postIdx;
    public String content;

    public CommentDB(int commentIdx, int userIdx, int postIdx, String content){
        this.commentIdx = commentIdx;
        this.userIdx = userIdx;
        this.postIdx = postIdx;
        this.content = content;
    }

}