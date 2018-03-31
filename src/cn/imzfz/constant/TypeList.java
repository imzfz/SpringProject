package cn.imzfz.constant;

/**
 * Created by zfz on 2018/3/24.
 * 用户类型枚举类，包含所有的用户类型
 */
public enum TypeList {
    User("0", "普通用户"),
    ADMIN("1", "管理员");

    public String role;
    public String desc;

    TypeList(String role, String desc){
        this.role = role;
        this.desc = desc;
    }

    /**
     * 判断该用户类型是否存在
     * @param role  用户类型
     * @return 存在返回true，否则返回false
     */
    public static boolean isRoleExsist(String role) {
        for (TypeList e : TypeList.values()) {
            if (e.getRole().equals(role)){
                return true;
            }
        }
        return false;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
