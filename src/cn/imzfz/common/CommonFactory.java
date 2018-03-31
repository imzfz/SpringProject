package cn.imzfz.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.imzfz.constant.TypeList;
import com.google.common.collect.Maps;

/**
 * Created by zfz on 2018/3/24.
 * 工厂类，将枚举类放到map中
 */
public class CommonFactory {
    public static final Map<String, List<Integer>> TYPE_MAP;

    static {
        TYPE_MAP = Maps.newConcurrentMap();
        TYPE_MAP.put(TypeList.User.role,Arrays.asList(0));
        TYPE_MAP.put(TypeList.ADMIN.role,Arrays.asList(1));
    }
}
