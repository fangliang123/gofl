package cn.gofl.system.controller;

import cn.gofl.common.domain.Page;
import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/sys/user")
public class UserController {

    private String URL_PREFIEX = "/sys/user/";

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list () {
        return URL_PREFIEX + "user_list";
    }

    @PostMapping("/add")
    public String add () {
        return URL_PREFIEX + "add";
    }

    @GetMapping("/remove")
    public String remove (){
        return URL_PREFIEX + "remove";
    }

    @PostMapping("/update")
    public String update () {
        return URL_PREFIEX + "update";
    }

    @PostMapping(value = "/listData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Page listData (@RequestParam Map<String, Object> params) {
        return userService.listPage(params);
    }


}
