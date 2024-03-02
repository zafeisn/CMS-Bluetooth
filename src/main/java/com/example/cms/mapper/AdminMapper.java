package com.example.cms.mapper;

import com.example.cms.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Title：AdminMapper
 * @Package：com.example.cms.mapper
 * @Description：管理员方法
 * @author：done
 * @date：2021/9/25 21:00
 */
@Mapper
public interface AdminMapper {

    // 查找全部管理员信息
    @Select("select * from t_admin")
    List<Admin> findAll();

    // 管理员登录，根据账号和密码进行查询
    @Select("select * from t_admin where username=#{userName} and password=#{passWord}")
    Admin findAdminByAll(String userName,String passWord);
}
