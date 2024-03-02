package com.example.cms.controller;

import com.example.cms.entity.Admin;
import com.example.cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Title：AdminController
 * @Package：com.example.cms.controller
 * @Description：管理员登录界面
 * @author：done
 * @date：2021/9/25 19:40
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(){
        List<Admin> adminAll = adminService.findAll();
        for (Admin admin: adminAll){
            System.out.println(admin);
        }
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(HttpServletRequest request,HttpSession session){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Admin admin = adminService.findAdminByAll(userName, passWord);
        if (admin != null){
            session.setAttribute("userName",userName);
            return "redirect:/";
        }
        return "login";
    }
}
