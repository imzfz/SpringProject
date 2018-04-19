package cn.imzfz.service;

import cn.imzfz.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2018/3/25.
 * 实现接口并集成抽象类，完成对数据库查的相关操作
 * 与查找用户相关的方法
 */
public class Select extends DAO implements ISelect<User>{
    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 查询到则返回用户
     */
    @Override
    public User findUserById(int id) {
        User user = null;
        if(isUserExist(id)){
            try {
                user = userMapper.findUserById(id);
            }catch (Exception e){
                logger.info("查询用户失败");
            }
        }
        return user;
    }

    /**
     * 根据loginName查询用户
     * @param loginName 登录名
     * @return 查询到则返回用户
     */
    @Override
    public User findUserByLoginName(String loginName) {
        User user = null;

        if(isUserExist(loginName)) {
            try {
                user = userMapper.findUserByLoginName(loginName);
            }catch (Exception e){
                logger.info("查询用户失败");
            }
        }
        return user;
    }

    /**
     * 根据name查询用户
     * @param name 用户名
     * @return 查询到则返回用户list
     */
    @Override
    public List<User> findUserByName(String name) {
        List<User> users = null;
        try {
            users = userMapper.findUserByName(name);
            if(users.size() > 0) {
                for (User u : users) {
                    logger.info("查询到用户 " + u.getLoginName());
                }
            }
            else {
                logger.info("未查询到用户");
            }
        }catch (Exception e){
            logger.info("查询用户失败");
        }
        return users;
    }

    /**
     * 返回所有用户信息
     * @return 用户list
     */
    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            users = userMapper.findAll();
            if(users.size() > 0) {
                logger.info("查询所有用户");
            }
            else {
                logger.info("未查询到用户");
            }
        }catch (Exception e){
            logger.info("查询用户失败");
        }

        return users;
    }
}
