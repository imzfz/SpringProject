package cn.imzfz.service;

import cn.imzfz.model.User;

/**
 * Created by zfz on 2018/4/9.
 */
public class Login extends DAO implements ILogin {

    public Login() {
        super();
    }

    @Override
    public boolean checkLogin() {
        return false;
    }

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
}
