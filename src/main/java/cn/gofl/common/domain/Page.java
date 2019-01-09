package cn.gofl.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页数据分页信息
 */
@Data
public class Page<T> {

    /**
     * 请求流水号
     */
    private int draw;

    /**
     * 总记录数(数据库里总共记录数)
     */
    private int recordsTotal;

    /**
     * 过滤后记录数
     */
    private int recordsFiltered;

    /**
     * 数据体信息
     */
    private List<T> data = new ArrayList<>();

    /**
     * page数据封装
     * @param <T>
     * @return
     */
    public static <T> Page<T> assembleData (int draw,
                                             int recordsTotal,
                                             int recordsFiltered,
                                             List<T> data) {
        Page<T> page = new Page<>();
        page.setDraw(draw);
        page.setRecordsTotal(recordsTotal);
        page.setRecordsFiltered(recordsFiltered);
        page.setData(data);
        return page;
    }

}
