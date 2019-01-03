package cn.gofl.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密
 */
public class MD5Util {

    private static final String SALT = "goflblog";
    private static final String ALGORITH_NAME = "md5";
    private static final Integer HASH_ITERATIONS = 2;

    public static String encrypt (String password) {
        String encPassword = new SimpleHash(ALGORITH_NAME,
                                            password,
                                            ByteSource.Util.bytes(SALT),
                                            HASH_ITERATIONS).toHex();
        return encPassword;
    }

    public static String encrypt (String username, String password) {
        String encPassword = new SimpleHash(ALGORITH_NAME,
                                            password,
                                            ByteSource.Util.bytes(username+SALT),
                                            HASH_ITERATIONS).toHex();
        return encPassword;
    }

    public static String md5(String str) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("md5算法出现错误！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("fangliang", "admin"));

        System.out.println(md5("21232f297a57a5a743894a0e4a801fc3"));
    }


}
