package cn.imzfz.aop;

import cn.imzfz.model.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zfz on 2018/3/31.
 */
public class LoginAdvice {
    public static final Logger logger = Logger.getLogger(LoginAdvice.class);

    /**
     * 在登录的时候对密码进行加密，并且修改参数
     * @param pjp
     * @return
     */
    public static Object md5(ProceedingJoinPoint pjp){
        Object args[] = pjp.getArgs();
        String pass = (String)args[1];

        if(pass == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try{
            byte[] btInput = pass.getBytes("utf-8");
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
            args[1] = new String(str);
            try {
                logger.info("登录密码已被加密");
                return pjp.proceed(args);
            }catch (Throwable e){
                e.printStackTrace();
            }
            return null;
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return null;
        }
    }
}
