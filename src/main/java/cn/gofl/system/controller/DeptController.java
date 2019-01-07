package cn.gofl.system.controller;

import cn.gofl.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 部门controller
 */
@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;


}
