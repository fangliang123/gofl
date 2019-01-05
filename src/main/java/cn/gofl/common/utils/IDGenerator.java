package cn.gofl.common.utils;

import java.util.Random;

/**
 * id生成器
 */
public class IDGenerator {

    private static final int RANDOM_RANGE = 100;

    /**
     * 生成id策略
     * 规则：id前缀+时间戳+三位随机数
     * @param prefix
     * @return
     */
    public static String id (String prefix) {
        long timestamp = System.currentTimeMillis() / 1000; //当前时间戳
        Random random = new Random();
        int val = random.nextInt(RANDOM_RANGE);

        return prefix
               .concat(String.valueOf(timestamp))
               .concat(StringUtil.lpad(String.valueOf(val), 3, '0'));
    }

    public static String menuId () {
        return null;
    }
}
