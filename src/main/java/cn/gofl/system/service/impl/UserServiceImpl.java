package cn.gofl.system.service.impl;

import cn.gofl.common.domain.Page;
import cn.gofl.system.dao.UserMapper;
import cn.gofl.system.domain.UserDO;
import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page listPage(Map<String, Object> query) {
        int total = userMapper.count(query);
        List<UserDO> data = userMapper.list(query);
        int rows =  Integer.parseInt((String) query.get("rows"));
        if (rows == 0 ){
            rows = 10;
        }
        int page = Integer.parseInt((String) query.get("page"));
        if (page == 0){
            page = 1;
        }
        return Page.assembleData(total, rows, page, data);
    }
}
