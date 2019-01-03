package cn.gofl.system.dao;

import cn.gofl.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询用户信息列表
     * @param params
     * @return
     */
    List<UserDO> list (@Param(value = "param") Map<String, Object> params);


}
