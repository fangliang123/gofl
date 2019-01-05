package cn.gofl.system.service.impl;

import cn.gofl.common.domain.Tree;
import cn.gofl.common.utils.BuildTree;
import cn.gofl.system.dao.MenuMapper;
import cn.gofl.system.domain.MenuDO;
import cn.gofl.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Tree<MenuDO>> listMenuByUId(String uid) {
        List<MenuDO> menuDOs = menuMapper.listByUid("0");
        if (menuDOs == null || menuDOs.size() == 0) {
            return null;
        }
        //将菜单信息封装进树结构里面
        List<Tree<MenuDO>> trees = new ArrayList<>();
        for (MenuDO menu: menuDOs) {
            Tree<MenuDO> tree = new Tree<>();
            tree.setId(menu.getMenuId());
            tree.setText(menu.getMenuName());
            tree.setParId(menu.getParentId());
            tree.getAttrs().put("icon", menu.getIcon());
            tree.getAttrs().put("href", menu.getHref());
            trees.add(tree);
        }
        return BuildTree.buildNav(trees, "0");
    }
}
