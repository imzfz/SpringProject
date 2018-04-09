package cn.imzfz.service;

import cn.imzfz.common.CommonFactory;
import cn.imzfz.constant.TypeList;
import cn.imzfz.mapper.UserMapper;
import cn.imzfz.model.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zfz on 2018/3/24.
 * 抽象DAO类，包含实现类需要的公共方法
 */
public abstract class DAO {
    final Logger logger = Logger.getLogger(this.getClass());
    protected final List<Integer> userList = CommonFactory.TYPE_MAP.get(TypeList.User.role);
    User user;

    /**
     * 使用注解注入mapper类，autowired通过名称注入
     */
    @Autowired
    protected UserMapper userMapper;

    /**
     * 检查用户是否符合删除条件
     *
     * @param id 用户id
     * @return
     */
    Boolean checkValid(int id) {
        try {
            user = userMapper.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUserExist(id) && userList.contains(user.getRole());
    }

    /**
     * 根据id判断用户是否存在
     *
     * @param id 用户id
     * @return 存在返回true 否则返回false
     */
    boolean isUserExist(int id) {
        try {
            user = userMapper.findUserById(id);
        } catch (Exception e) {
            logger.info("查询出错");
            e.printStackTrace();
        }
        if (user != null) {
            logger.info(String.format("查询到用户 %s ", user.getName()));
            return true;
        }
        logger.info("查询的用户不存在");
        return false;

    }

    /**
     * 根据登录名判断用户是否存在
     *
     * @param loginName 登录名
     * @return 存在返回true 否则返回false
     */
    boolean isUserExist(String loginName) {
        try {
            user = userMapper.findUserByLoginName(loginName);
        } catch (Exception e) {
            logger.info("查询出错");
            e.printStackTrace();
        }
        if (user != null) {
            logger.info(String.format("查询到用户 %s ", user.getName()));
            return true;
        }
        logger.info("查询的用户不存在");
        return false;

    }

    /**
     * 判断登录名是否合法
     * @param loginName 登录名
     * @return 全为字母则返回true
     */
    boolean checkLoginName(String loginName){
        if(loginName.matches("[a-zA-Z0-9]+")){
            return true;
        }
        logger.info("登录名必须为英语字母或数字");
        return false;
    }
}
