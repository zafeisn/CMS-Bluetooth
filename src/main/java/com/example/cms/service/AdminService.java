package com.example.cms.service;

import com.example.cms.entity.Admin;
import com.example.cms.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title：AdminService
 * @Package：com.example.cms.service
 * @Description：
 * @author：done
 * @date：2021/9/25 21:04
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    // 查找全部管理员信息
    public List<Admin> findAll(){
        return adminMapper.findAll();
    }

    // 管理员登录，根据账号和密码进行查询
    public Admin findAdminByAll(String userName,String passWord){
        return adminMapper.findAdminByAll(userName,passWord);
    }
}
