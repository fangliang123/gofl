package cn.gofl.common.utils;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 类似mysql的lpad字符串填充函数
     * @param str 字符穿
     * @param len 长度
     * @param ch 用来填充的字符
     */
    public static String lpad (String str, int len, char ch) {
        StringBuffer sb = new StringBuffer();
        if (str.length() >= len) {
            return str;
        }
        for (int i = 0; i < len - str.length(); i++){
            sb.append(ch);
        }
        return sb.toString().concat(str);
    }
}
