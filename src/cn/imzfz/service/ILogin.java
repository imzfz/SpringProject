package cn.imzfz.service;

import cn.imzfz.model.Record;

/**
 * Created by zfz on 2018/4/9.
 */
public interface ILogin {
    boolean checkLogin();
    boolean isValidUser(String loginName, String password);
}
