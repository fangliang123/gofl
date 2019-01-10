package cn.gofl.common.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页数据分页信息
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Page<T> {

    /**
     * 总页数
     */
    private int total;

    /**
     * 当前页
     */
    private int page;

    /**
     * 过滤后记录数
     */
    private int records;

    /**
     * 数据体信息
     */
    private List<T> rows;

    /**
     * page数据封装
     * @param <T>
     * @return
     */
    public static <T> Page<T> assembleData (int records, int pageSize, int page, List<T> data) {
        Page<T> pageData = new Page<>();
        pageData.setRecords(records); // 总记录数
        //总页数
        int total;
        if (records % pageSize == 0){
            total = records / pageSize;
        } else {
            total = records / pageSize + 1;
        }
        pageData.setTotal(total); // 总页数
        pageData.setPage(page); // 当前页
        pageData.setRows(data); // 分页数据
        return pageData;
    }


}
