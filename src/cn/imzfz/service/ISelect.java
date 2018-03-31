package cn.imzfz.service;

import cn.imzfz.model.User;

import java.util.List;

/**
 * Created by zfz on 2018/3/25.
 */
public interface ISelect<T> {
    T findUserById(int id);
    T findUserByLoginName(String loginName);
    List<T> findUserByName(String name);
}
