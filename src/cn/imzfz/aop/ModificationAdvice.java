package cn.imzfz.aop;

import cn.imzfz.model.Record;
import cn.imzfz.model.User;
import cn.imzfz.service.IPersist;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zfz on 2018/3/31.
 *
 */
public class ModificationAdvice {
    public static final Logger logger = Logger.getLogger(ModificationAdvice.class);

    @Autowired
    IPersist<User> persist;

    /**
     * md5加密算法
     * @param user 用户实体
     * @return 加密后的密码
     */
    public static String md5(User user) {
        String password = user.getPassword();
        if(password == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try{
            byte[] btInput = password.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            user.setPassword(new String(str));
            logger.info("密码已被加密");
            return new String(str);
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return null;
        }
    }

    /**
     * 记录操作日志
     * @param jp
     * @param result
     */
    public void saveRecord(JoinPoint jp, boolean result){
        persist.saveRecord(new Record("123", "123123123",
                jp.getSignature().getName(), "" + result));
    }

}
