package cn.imzfz.service;

import cn.imzfz.model.Record;

/**
 * Created by zfz on 2018/3/24.
 */
public interface IPersist<T> {
    boolean addUser(T t);
    boolean delUser(int id);
    boolean updateUser(T t);
    void saveRecord(Record record);
}
