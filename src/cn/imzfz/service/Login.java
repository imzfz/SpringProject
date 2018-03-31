package cn.imzfz.service;

import cn.imzfz.aop.LoginAdvice;

/**
 * Created by zfz on 2018/3/31.
 */
public class Login extends DAO implements ILogin{

    @Override
    public boolean check(String loginName, String password) {
        return false;
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }
}
