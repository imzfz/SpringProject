package cn.imzfz.mapper;

import cn.imzfz.constant.SexList;
import cn.imzfz.model.User;
import cn.imzfz.service.IPersist;

import cn.imzfz.service.ISelect;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;


/**
 * Created by zfz on 2018/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "/application.xml")
public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Resource
    private IPersist<User> persist;

    @Resource
    private ISelect<User> select;

    @Test
    public void addUser() throws Exception {
        User user = new User("哈哈","大李", "121sfgewfa3", "男", 13, 0);
        persist.addUser(user);
    }

    @Test
    public void delUser() throws Exception {
        persist.delUser(19);
    }

    @Test
    public void updateUser() throws Exception {
        User user = select.findUserById(15);
        if (user != null) {
            user.setAddress("北京市朝阳区");
            persist.updateUser(user, 2);
        }
    }

    @Test
    public void findUserById() throws Exception {
        select.findUserById(1);
    }

    @Test
    public void findUserByLoginName() throws Exception {
        select.findUserByLoginName("xiaoli");
    }

    @Test
    public void findUserByName() throws Exception {
        select.findUserByName("小李");
    }

}