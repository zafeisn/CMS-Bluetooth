package com.example.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title：IndexController
 * @Package：com.example.cms.controller
 * @Description：访问主页面
 * @author：done
 * @date：2021/9/25 19:44
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
