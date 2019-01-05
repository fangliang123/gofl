package cn.gofl.system.service;

import cn.gofl.common.domain.Page;
import cn.gofl.common.utils.Query;
import cn.gofl.system.domain.UserDO;


/**
 * 用户信息接口
 */
public interface UserService {

    /**
     * 用户列表接口
     * @param query
     * @return
     */
    Page<UserDO> listPage (Query query);
}
