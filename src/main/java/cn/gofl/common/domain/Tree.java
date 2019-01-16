package cn.gofl.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构
 */
@Data
public class Tree <T>{

    private String id;

    private String text;

    private String parId;

    private Map<String, Object> states;

    /**
     * 节点是否被选中
     */
    private boolean choose;

    private boolean hasParent;

    private boolean hasChildren;

    private Map<String, Object> attrs = new HashMap<>();

    private List<Tree<T>> children = new ArrayList<>();

    /**
     * 页面打开类型 iframe-tab
     */
    private String targetType = "iframe-tab";

}
