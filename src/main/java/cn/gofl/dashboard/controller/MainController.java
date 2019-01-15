package cn.gofl.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/admin")
public class MainController {

    private String uriPrefiex = "admin/dashboard/";

    @GetMapping(value = "/main")
    public String dashboard (){
        return uriPrefiex + "dashboard";
    }
}
