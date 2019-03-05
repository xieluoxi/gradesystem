package com.qdedu.gradesystem.entity;

import cn.bmob.v3.BmobObject;

/**
 * desc :
 * author：xiedong
 * date：2019/3/5
 */
public class ScoreEntity extends BmobObject {

    private String userName;
    private String ScoreTypeName;
    private int score;
    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScoreTypeName() {
        return ScoreTypeName;
    }

    public void setScoreTypeName(String scoreTypeName) {
        ScoreTypeName = scoreTypeName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
