package cn.gofl.system.dao;

import cn.gofl.common.utils.Query;
import cn.gofl.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询用户记录数
     * @param query
     * @return
     */
    int count (@Param(value = "codition") Query query);

    /**
     * 查询用户信息列表
     * @param query
     * @return
     */
    List<UserDO> list (@Param(value = "condition") Query query);


}
