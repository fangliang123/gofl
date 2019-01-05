package cn.gofl.system.service.impl;

import cn.gofl.common.domain.Page;
import cn.gofl.common.utils.Query;
import cn.gofl.system.dao.UserMapper;
import cn.gofl.system.domain.UserDO;
import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserDO> listPage(Query query) {
        int total = userMapper.count(query);
        List<UserDO> rows = userMapper.list(query);
        return Page.assemble(total, rows);
    }
}
