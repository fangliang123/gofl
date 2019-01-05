package cn.gofl.common.utils;

import java.util.Date;
import java.util.Random;

/**
 * id生成器
 */
public class IDGenerator {

    public static String userId (String prefix) {

        long timestamp = System.currentTimeMillis() / 1000; //当前时间戳
        Random random = new Random();
        int val = random.nextInt(100);

        return prefix + timestamp;


    }

}
