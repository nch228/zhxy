package com.atguigu.zhxy.controller;

import com.atguigu.zhxy.pojo.Clazz;
import com.atguigu.zhxy.pojo.Student;
import com.atguigu.zhxy.pojo.Teacher;
import com.atguigu.zhxy.service.TeacherService;
import com.atguigu.zhxy.util.MD5;
import com.atguigu.zhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nie
 * @create 2022-12-28-20:30
 */
@RestController
@RequestMapping("sms/teacherController")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result getTeachers(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            Teacher teacher
    ){
        Page<Teacher> page =new Page<>(pageNo,pageSize);

        IPage<Teacher> iPage=teacherService.getTeachers(page,teacher);

        return Result.ok(iPage);

    }

    @DeleteMapping("/deleteTeacher")
    public Result deleteTeacher(
            @RequestBody List<Integer> ids
    ){
        teacherService.removeByIds(ids);
        return Result.ok();
    }


    @PostMapping("/saveOrUpdateTeacher")
    public Result saveOrUpdateTeacher(
            @RequestBody Teacher teacher
    ){
        Integer id =teacher.getId();
        if(null==id||0==id){
            teacher.setPassword(MD5.encrypt(teacher.getPassword()));
        }
        //接收参数
        //调用服务层方法完成增减或者修改
        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }


}
