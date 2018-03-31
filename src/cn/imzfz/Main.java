package cn.imzfz;

import cn.imzfz.model.User;

import java.io.*;

/**
 * Created by zfz on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.getAge());
        test(user);
        System.out.println(user.getAge());
    }

    public static void test(User user){
        user.setAge(23);
    }
}
