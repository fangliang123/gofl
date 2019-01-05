package cn.gofl.common.utils;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请求参数封装
 */
@Data
public class Query extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private int offset;

    private int limit;

    public Query (){}

    public Query (Map<String, Object> params) {
        this.offset = (Integer) params.get("offset");
        this.limit = (Integer) params.get("limit");
        this.put("offset", offset);
        this.put("page", offset / limit + 1);
        this.put("limit", limit);
    }

}
