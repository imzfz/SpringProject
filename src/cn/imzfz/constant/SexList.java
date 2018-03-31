package cn.imzfz.constant;

/**
 * Created by zfz on 2018/3/25.
 * 用户性别枚举类
 */
public enum SexList {
    Male("男", "male"),
    Female("女", "female");

    public String sex;
    public String des;

    SexList(String sex, String des) {
        this.sex = sex;
        this.des = des;
    }

    /**
     * 判断该用户性别类型是否存在
     * @param sex 性别类型
     * @return 存在返回true 否则返回false
     */
    public static boolean isSexExsist(String sex) {
        for (SexList e : SexList.values()) {
            if (e.getSex().equals(sex)){
                return true;
            }
        }
        return false;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
