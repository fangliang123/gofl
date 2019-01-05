package cn.gofl.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页数据分页信息
 */
@Data
public class Page<T> {

    private int offset;

    private int limit;

    private int total;

    private Map<String, Object> params;

    private String param;

    private List<T> rows = new ArrayList<>();

    /**
     * 封装page数据
     * @param <T>
     * @return
     */
    public static <T> Page<T> assemble (int total, List<T> rows) {
        if (total == 0 || rows.size() == 0) {
           return null;
        }
        Page<T> page = new Page<>();
        page.setTotal(total);
        page.setRows(rows);
        return page;
    }
}
