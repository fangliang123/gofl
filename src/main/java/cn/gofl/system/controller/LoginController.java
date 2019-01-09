package cn.gofl.system.controller;

import cn.gofl.common.domain.Tree;
import cn.gofl.common.utils.MD5Util;
import cn.gofl.common.utils.Result;
import cn.gofl.system.domain.MenuDO;
import cn.gofl.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 登录控制器
 */
@Controller
public class LoginController {

    @Autowired
    private MenuService menuService;

    @RequestMapping({"/admin"})
    public String index (Model model, HttpServletRequest request) {
        model.addAttribute("username","fangliang");
        List<Tree<MenuDO>> trees =  menuService.listMenuByUId("0");
//        model.addAttribute("menus", trees);
        request.getSession().setAttribute("username", "FangLiang");
        request.getSession().setAttribute("menus", trees);
        return "index";
    }

    @GetMapping("/login")
    public String login () {
        return "/login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login (String username, String password) {
        password = MD5Util.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Result.ok();
        } catch (AuthenticationException e) {
            return Result.error(1, "用户名或者密码错误!");
        }
    }

    @GetMapping("/403")
    public String unauthorized () {
        return "/error/403";
    }

}
