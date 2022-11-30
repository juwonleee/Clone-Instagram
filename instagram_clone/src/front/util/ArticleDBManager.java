package front.util;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDBManager {
    private Connection con;
    private Statement stat;
    private static int cur_userIdx = -1;

    /**
     * Make connection to the DB
     */

    public ArticleDBManager(){
        String url = "jdbc:mysql://localhost:3306/clone-instagram";
        String userid = "root";
        String pwd = "1234";

        try{
            con = DriverManager.getConnection(url, userid, pwd);
            stat = con.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArticleDBManager(int cur_userIdx){
        setCurrentUser(cur_userIdx);
        String url = "jdbc:mysql://localhost:3306/clone-instagram";
        String userid = "root";
        String pwd = "1234";

        try{
            con = DriverManager.getConnection(url, userid, pwd);
            stat = con.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void setCurrentUser(int idx){
        cur_userIdx = idx;
    }

    public static int getCurrentUserIdx(){
        return cur_userIdx;
    }

    public String getCurrentUsername(){
        return getUsername(cur_userIdx);
    }
    /*
    필요한 기능:
        load article list
        load image of an article
        load message of an article
        load comments of ah article
        get num of comments
        load/update article like
        load/update comment like
        write a comment
        @user comment => set 'tagUser'
     */

    /**
     * Get all articles from DB.
     * @return List of articles
     */
    public ArrayList<ArticleDB> getArticleList(){
        ArrayList<ArticleDB> list = new ArrayList<>();
        String query = "select * from post;";

        try {
            stat = con.createStatement();
            ResultSet result = stat.executeQuery(query);

            while(result.next()){ //init each article
                int postIdx = result.getInt("postIdx");
                int userIdx = result.getInt("userIdx");
                String content = result.getString("content");
                ArrayList<CommentDB> comments = getCommentList(postIdx);

                list.add(new ArticleDB(postIdx, userIdx, content, comments));
            }

            result.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Get comment list from DB.
     * @param articleId ID of the article ('postId' at DB)
     * @return List of comments
     */
    public ArrayList<CommentDB> getCommentList(int articleId){
        ArrayList<CommentDB> list = new ArrayList<>();
        String query = "select * from comment where postIdx=" + "\"" + articleId + "\"" + " order by createdAt desc";

        try{
            stat = con.createStatement();
            ResultSet result = stat.executeQuery(query);

            while(result.next()){
                int commentIdx = result.getInt("commentIdx");
                int userIdx = result.getInt("userIdx");
                int postIdx = result.getInt("postIdx");
                String content = result.getString("content");

                list.add(new CommentDB(commentIdx, userIdx, postIdx, content));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Add comment to DB
     * if msg = "@user ...", then add the user to tagUser
     * Need to execute setCurrentUser(idx) first before the execution
     */
    public void addComment(String msg, ArticleDB article){
        if (msg.startsWith("@")){
            String name = msg.substring(1).split(" ")[0];

            int userIdx = getUserIdx(name);
            if (userIdx != -1){
                String query = "insert into comment values(default," + cur_userIdx + "," + article.postIdx + ",\"" + msg + "\",default," + userIdx + ")";

                try{
                    stat.executeUpdate(query);
                    return;
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        String query = "insert into comment values(default," + cur_userIdx + "," + article.postIdx + ",\"" + msg + "\",default,null)";
        try{
            stat.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    //...댓글 하트 기능 추가DB


    /**
     * Get username from the given userIdx
     * @param userIdx
     * @return username
     */
    public String getUsername(int userIdx){
        String query = "select nickname from user where userIdx=" + userIdx;

        try{
            ResultSet result = stat.executeQuery(query);
            if (result.next()){
                return result.getString(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get userIdx from the given username
     * @param username
     * @return userIdx of the user
     */
    public int getUserIdx(String username){
        String query = "select userIdx from user where nickname=" + "\"" + username + "\"";

        try{
            ResultSet result = stat.executeQuery(query);
            if (result.next()){
                return result.getInt(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }
}