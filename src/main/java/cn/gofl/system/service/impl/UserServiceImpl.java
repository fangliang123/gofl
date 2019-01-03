package cn.gofl.system.service.impl;

import cn.gofl.system.dao.UserMapper;
import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;




}
