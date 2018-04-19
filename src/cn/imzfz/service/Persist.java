package cn.imzfz.service;

import cn.imzfz.constant.SexList;
import cn.imzfz.constant.TypeList;
import cn.imzfz.model.Record;
import cn.imzfz.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by zfz on 2018/3/25.
 * 继承抽象类并且实现接口，完成对数据库的操作
 */
public class Persist extends DAO implements IPersist<User> {

    public Persist() {
        super();
        logger.info("调用无参构造方法");
    }

    /**
     * 添加用户，如果用户类型在类型列表中
     * 且用户名，登录名，密码，性别不为空则可以添加
     *
     * @param user 用户bean
     * @return 成功则返回true 否则返回false
     */
    @Override
    public boolean addUser(User user) {
        boolean valid = !StringUtils.isBlank(user.getLoginName()) && !StringUtils.isBlank(user.getName()) &&
                !StringUtils.isBlank(user.getPassword()) && TypeList.isRoleExsist(String.valueOf(user.getRole()))
                && SexList.isSexExsist(String.valueOf(user.getSex()));
        if(isUserExist(user.getLoginName())){
            logger.info(String.format("添加用户 %s 失败,用户 %s 已存在", user.getName(), user.getLoginName()));
            return false;
        }

        if (valid && checkLoginName(user.getLoginName())) {
            try {
                if (userMapper.addUser(user)) {
                    logger.info(String.format("添加用户 %s 成功", user.getName()));
                    return true;
                }
            } catch (Exception e) {
                logger.info(String.format("添加用户 %s 失败", user.getName()));
                logger.error("ERROR", e);
            }
        }
        logger.info(String.format("添加用户 %s 失败", user.getName()));
        return false;
    }

    /**
     * 根据id删除用户，如果用户类型不为1，则可以删除
     *
     * @param id 用户id
     * @return 成功返回true 否则返回false
     */
    @Override
    public boolean delUser(int id) {

        if (!checkValid(id)) {
            logger.info("该用户无法被删除");
            return false;
        }

        if (TypeList.isRoleExsist(String.valueOf(user.getRole()))) {
            try {
                userMapper.delUser(id);
                logger.info(String.format("删除用户 %s 成功", user.getName()));
                return true;
            } catch (Exception e) {
                logger.info("删除用户失败");
                logger.error("ERROR", e);
            }
        }
        logger.info("删除用户失败");
        return false;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户新信息
     * @return 更新成功返回true 否则返回false
     */
    @Override
    public boolean updateUser(User user) {
        boolean valid = !StringUtils.isBlank(user.getName()) && !StringUtils.isBlank(user.getPassword())
                && TypeList.isRoleExsist(String.valueOf(user.getRole()))
                && SexList.isSexExsist(String.valueOf(user.getSex()));
        if (valid && isUserExist(user.getId())) {
            try {
                if (userMapper.updateUser(user)) {
                    logger.info(String.format("更新用户 %s 成功", user.getName()));
                    return true;
                }
            } catch (Exception e) {
                logger.info(String.format("更新用户 %s 失败", user.getName()));
                logger.error("ERROR", e);
            }
        }
        logger.info(String.format("更新用户 %s 失败", user.getName()));
        return false;
    }

    @Override
    public void saveRecord(Record record) {
        recordMapper.record(record);
    }
}
