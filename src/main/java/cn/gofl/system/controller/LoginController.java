package cn.gofl.system.controller;

import cn.gofl.common.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 */
@Controller
public class LoginController {

    @RequestMapping({"", "/", "/index"})
    public String index () {
        return "index";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @PostMapping("/login")
    public String login (String username, String password) {
        password = MD5Util.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "/login";
        }
    }

    @GetMapping("/403")
    public String unauthorized () {
        return "/error/403";
    }

}
