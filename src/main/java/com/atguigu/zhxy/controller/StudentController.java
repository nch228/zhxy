package com.atguigu.zhxy.controller;

import com.atguigu.zhxy.pojo.Grade;
import com.atguigu.zhxy.pojo.Student;
import com.atguigu.zhxy.service.StudentService;
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
@RequestMapping("sms/studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @DeleteMapping("/delStudentById")
    public Result delStudentById(
            @RequestBody List<Integer> ids
    ){
        studentService.removeByIds(ids);
        return Result.ok();
    }


    @PostMapping("/addOrUpdateStudent")
    public Result addOrUpdateStudent(
            @RequestBody Student student
    ){
        Integer id =student.getId();
        if(null==id||0==id){
            student.setPassword(MD5.encrypt(student.getPassword()));
        }
        //接收参数
        //调用服务层方法完成增减或者修改
        studentService.saveOrUpdate(student);
        return Result.ok();
    }

    @GetMapping("/getStudentByOpr/{pageNo}/{pageSize}")
    public Result getStudentByOpr(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            Student student
    ){
        // 分页 带条件查询
        Page<Student> page =new Page<>(pageNo,pageSize);
        // 通过服务层
        IPage<Student> pageRs=studentService.getStudentByOpr(page,student);

        // 封装Result对象并返回
        return Result.ok(pageRs);
    }
}
