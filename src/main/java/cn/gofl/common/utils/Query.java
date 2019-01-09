package cn.gofl.common.utils;

import lombok.Data;

import java.util.LinkedHashMap;

/**
 * 请求参数封装
 */
@Data
public class Query extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 绘制计数器
     */
    private int draw;

    /**
     * 起始位置
     */
    private int start;

    /**
     * 每页显示
     */
    private int length;


    public Query (){}

    public Query (int drow, int start, int length) {
        this.draw = drow;
        this.start = start;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Query{" +
                "draw=" + draw +
                ", start=" + start +
                ", length=" + length +
                '}';
    }
}
