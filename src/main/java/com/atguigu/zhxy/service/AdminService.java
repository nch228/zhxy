package com.atguigu.zhxy.service;

import com.atguigu.zhxy.pojo.Admin;
import com.atguigu.zhxy.pojo.LoginForm;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author nie
 * @create 2022-12-28-19:50
 */
public interface AdminService extends IService<Admin> {
    Admin login(LoginForm loginForm);

    Admin getAdminById(Long userId);

    IPage<Admin> getAllAdmin(Page<Admin> page, String adminName);
}
