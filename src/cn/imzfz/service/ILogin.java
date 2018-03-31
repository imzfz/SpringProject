package cn.imzfz.service;

/**
 * Created by zfz on 2018/3/31.
 */
public interface ILogin {
    boolean check(String loginName, String password);
    boolean isLoggedIn();
}
