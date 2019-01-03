package cn.gofl.common.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果信息映射
 */
public class Result extends HashMap<String, Object> {

    public Result () {
        this.put("code",0);
        this.put("msg", "success");
    }

    public static Result error (String msg) {
        Result result = new Result();
        result.put("code", 1);
        result.put("msg", msg);
        return result;
    }

    public static Result error (Integer code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result ok (Map<String, Object> map) {
        Result result = new Result();
        result.put("code", 0);
        result.put("msg", "success");
        result.putAll(map);
        return result;
    }

    public static Result ok (Object obj) {
        Result result = new Result();
        result.put("code", 0);
        result.put("msg", "success");
        result.put("data", obj);
        return result;
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        super.putAll(m);
    }
}
