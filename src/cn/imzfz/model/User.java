package cn.imzfz.model;

import cn.imzfz.constant.TypeList;

import javax.validation.constraints.NotNull;

/**
 * Created by zfz on 2018/3/11.
 * class of student info
 */
public class User {
    private int id;
    @NotNull(message = "用户名不能为空")
    private String loginName;
    private String name;
    private String password;
    private String sex = "";
    private int age;
    private int role;
    private String address = "";

    public User() {
    }

    public User(String loginName, String name, String password, String sex, int age, int role, String address) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.role = role;
        this.address = address;
    }

    /**
     * address为非必填项，不包含address的构造方法
     * @param loginName 登录名
     * @param name 姓名
     * @param password 密码
     * @param sex 性别
     * @param age 年龄
     * @param role 用户类别
     */
    public User(String loginName, String name, String password, String sex, int age, int role) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
