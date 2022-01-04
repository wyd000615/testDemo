package com.pojo;


/**
 * 该对象是将用户换机信息中用户登录成功次数和换机次数存入redis使用
 */
public class LoginCnt {
    private int loginSuccessCount; //成功登录次数
    private int changeImeiCount;//换机次数

    @Override
    public String toString() {
        return "LoginCnt{" +
                "loginSuccessCount=" + loginSuccessCount +
                ", changeImeiCount=" + changeImeiCount +
                '}';
    }

    public int getLoginSuccessCount() {
        return loginSuccessCount;
    }

    public void setLoginSuccessCount(int loginSuccessCount) {
        this.loginSuccessCount = loginSuccessCount;
    }

    public int getChangeImeiCount() {
        return changeImeiCount;
    }

    public void setChangeImeiCount(int changeImeiCount) {
        this.changeImeiCount = changeImeiCount;
    }
}