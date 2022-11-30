package front.util;

import java.util.ArrayList;

public class UserDB {


    private int userIdx;
    private String name;
    private String nickName;
    private String email;
    private String pwd;
    private String profileImgURL;
    private String introduction;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }
    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
