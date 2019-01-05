package cn.gofl.system.service;

import cn.gofl.common.domain.Tree;
import cn.gofl.system.domain.MenuDO;

import java.util.List;

/**
 * 菜单类接口
 */

public interface MenuService {

    /**
     * 对应用户权限的菜单信息
     * @param uid
     * @return
     */
    List<Tree<MenuDO>> listMenuByUId (String uid);
}
