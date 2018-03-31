package cn.imzfz.mapper;

import cn.imzfz.model.User;

import java.util.List;

/**
 * Created by zfz on 2018/3/24.
 */
public interface UserMapper {
    boolean addUser(User user);
    boolean delUser(int id);
    boolean updateUser(User user);
    User findUserById(int id);
    User findUserByLoginName(String name);
    List<User> findUserByName(String name);
}
