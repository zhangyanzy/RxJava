package com.zhangyan.rxjava.bean;

/**
 * Created by zhangYan on 2018/1/16.
 */

public class LoginRequest {

    public String userName;

    public LoginRequest() {
    }

    public LoginRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
