package com.example.cms.entity;

import lombok.Data;

/**
 * @Title：Admin
 * @Package：com.example.cms.dao
 * @Description：管理员实体类
 * @author：done
 * @date：2021/9/25 20:58
 */
@Data
public class Admin {
    private Integer id;
    private String userName;
    private String passWord;
    private String description;
}
