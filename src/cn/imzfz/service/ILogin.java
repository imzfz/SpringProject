package cn.imzfz.service;

/**
 * Created by zfz on 2018/4/9.
 */
public interface ILogin {
    boolean checkLogin();
    boolean isValidUser(String loginName, String password);
}
