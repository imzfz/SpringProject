package cn.imzfz.service;

import cn.imzfz.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by zfz on 2018/4/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "/application.xml")

public class LoginTest {
    @Resource
    private ILogin login;


    @Test
    public void checkLogin() throws Exception {
    }

    @Test
    public void isValidUser() throws Exception {
        login.isValidUser("test1234", "admin");
    }

}