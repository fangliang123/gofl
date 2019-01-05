package cn.gofl.common.utils;

import cn.gofl.common.domain.Tree;
import cn.gofl.system.domain.MenuDO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建树形结构
 */

public class BuildTree {


    /**
     * 构建树形结构
     * @param uid
     * @param topId
     * @return
     */
    public static List<Tree<MenuDO>> buildTree (String uid, String topId) {
        return null;
    }

    /**
     * 根据菜单构建导航栏
     * @param nodes
     * @param topId
     * @return
     */
    public static <T> List<Tree<T>> buildNav (List<Tree<T>> nodes, String topId) {
        List<Tree<T>> topNodes = new ArrayList<>(16);
        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        for (Tree<T> children: nodes) {
            String parId = children.getParId();
            if (parId == null || "0".equals(parId)) {
                topNodes.add(children);
                continue;
            }
            for (Tree<T> parent : nodes) {
                String id = parent.getId();
                if (StringUtils.isNotEmpty(id) && id.equals(parId))  {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setHasChildren(true);
                }
            }

        }
        return topNodes;
    }

}
