package com.atguigu.zhxy.controller;

import com.atguigu.zhxy.pojo.Admin;
import com.atguigu.zhxy.pojo.Grade;
import com.atguigu.zhxy.service.AdminService;
import com.atguigu.zhxy.util.MD5;
import com.atguigu.zhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nie
 * @create 2022-12-28-20:29
 */
@RestController
@RequestMapping("sms/adminController")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(
            @RequestBody List<Integer> ids
    ){
        adminService.removeByIds(ids);
        return Result.ok();
    }

    @PostMapping("/saveOrUpdateAdmin")
    public Result saveOrUpdateAdmin(
            @RequestBody Admin admin
    ){
        Integer id =admin.getId();
        if(null==id||0==id){
            admin.setPassword(MD5.encrypt(admin.getPassword()));
        }

        //接收参数
        //调用服务层方法完成增减或者修改
        adminService.saveOrUpdate(admin);
        return Result.ok();
    }

    @GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
    public Result getAllAdmin(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            String adminName
    ){
        Page<Admin> page =new Page<>(pageNo,pageSize);

        IPage<Admin> iPage=adminService.getAllAdmin(page,adminName);

        return Result.ok(iPage);

    }
}
