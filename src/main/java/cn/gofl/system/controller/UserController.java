package cn.gofl.system.controller;

import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 */

@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     */
    @GetMapping("/list")
    public void list () {

    }



}
