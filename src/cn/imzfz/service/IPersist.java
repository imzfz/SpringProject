package cn.imzfz.service;

/**
 * Created by zfz on 2018/3/24.
 */
public interface IPersist<T> {
    boolean addUser(T t);
    boolean delUser(int id);
    boolean updateUser(T t, int id);
}
