package cn.gofl.system.dao;

import cn.gofl.system.domain.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDO> listByUid (@Param(value = "uid") String uid);
}
