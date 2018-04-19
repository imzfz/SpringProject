package cn.imzfz.service;

import cn.imzfz.model.Record;
import cn.imzfz.model.User;

/**
 * Created by zfz on 2018/4/9.
 * 继承抽象类并且实现接口，完成对数据库的操作
 * 与用户登录相关的服务层方法
 */
public class Login extends DAO implements ILogin {

    public Login() {
        super();
    }

    @Override
    public boolean checkLogin() {
        return false;
    }

    /**
     * 验证登录用户是否合法
     * @param loginName 登录名
     * @param password 密码
     * @return
     */
    @Override
    public boolean isValidUser(String loginName, String password) {
        if(isUserExist(loginName)) {
            try {
                String pswd = userMapper.checkValidUser(loginName);
                if(pswd.equals(password)){
                    logger.info(String.format("用户 %s 登录成功", loginName));
                    return true;
                }
            }catch (Exception e){
                logger.info("登录失败");
            }
        }
        logger.info(String.format("尝试登录 %s 失败, 用户名或密码错误", loginName));
        return false;
    }

    /**
     * 记录操作日志
     * @param record
     */
    @Override
    public void saveRecord(Record record) {
        recordMapper.record(record);
    }
}
