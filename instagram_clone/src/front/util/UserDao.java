package front.util;

import java.sql.*;


public class UserDao {

    private static UserDao dao = new UserDao();
    public static UserDao getInstance() {
        return dao;
    }
    private ResultSet rs;

    /**
     * Make connection to the DB
     */
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/madang";
        String userid = "madang";
        String pwd = "1234";
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(url, userid, pwd);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
        }
        close(conn, ps);
    }

    public void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
        }
    }


    /**
     * Add user to DB
     */
    public void addUser(UserDB userDB) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("insert into user(name, nickName, email, pwd) values(?,?,?,?)");
            pstmt.setString(1, userDB.getName());
            pstmt.setString(2, userDB.getNickName());
            pstmt.setString(3, userDB.getEmail());
            pstmt.setString(4, userDB.getPwd());
            pstmt.executeUpdate();

            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn, pstmt);
        }
    }

    /**
     * Update password to DB user table
     */
    public void updatePwd(String email, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("update user set pwd=? where email=?");
            pstmt.setString(1, pwd);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }
    }


    /**
     * login
     */
    public int login(UserDB userDB) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String SQL = "SELECT pwd FROM USER WHERE name = ? or nickName=? or  email=?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userDB.getName());
            pstmt.setString(2, userDB.getNickName());
            pstmt.setString(3, userDB.getEmail());
            rs = pstmt.executeQuery(); // ????????? ????????? ???????????? ResultSet ????????? rs ????????? ???????????? ????????? ????????? ?????????
            if (rs.next()) {
                if (rs.getString(1).contentEquals(userDB.getPwd())) {
                    return 1; // ????????? ??????
                }
                else {
                    return 0; // ???????????? ?????????
                }
            }
            return -1; // ???????????? ??????
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -2; // DB ??????
    }




}

