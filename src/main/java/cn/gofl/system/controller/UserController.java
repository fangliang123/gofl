package cn.gofl.system.controller;

import cn.gofl.common.domain.Page;
import cn.gofl.common.utils.Query;
import cn.gofl.system.domain.UserDO;
import cn.gofl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
//@RequestMapping("/sys/user")
public class UserController {

    private String URL_PREFIEX = "/sys/user";

    @Autowired
    private UserService userService;


    @GetMapping("/userlist")
    public String test_index () {
        return "/sys/user/list";
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public Page<UserDO> list (@RequestParam Map<String, Object> params) {
        //请求参数校验，分页信息
        Query query = new Query(params);
        return userService.listPage(query);
    }

    @RequestMapping("/test")
    public String index() {
        return "/sys/user/test";
    }

}
