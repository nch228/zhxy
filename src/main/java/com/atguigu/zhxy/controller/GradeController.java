package com.atguigu.zhxy.controller;

import com.atguigu.zhxy.pojo.Grade;
import com.atguigu.zhxy.service.GradeService;
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
@RequestMapping("sms/gradeController")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/getGrades")
    public Result getGrades(){
        List<Grade> grades=gradeService.getGrades();
        return Result.ok(grades);
    }

    @DeleteMapping("/deleteGrade")
    public Result deleteGrade(
            @RequestBody List<Integer> ids
            ){
        gradeService.removeByIds(ids);
        return Result.ok();
    }

    @PostMapping("/saveOrUpdateGrade")
    public Result saveOrUpdateGrade(
            @RequestBody Grade grade
    ){
        //接收参数
        //调用服务层方法完成增减或者修改
        gradeService.saveOrUpdate(grade);
        return Result.ok();
    }
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result getGrades(
             @PathVariable("pageNo") Integer pageNo,
             @PathVariable("pageSize") Integer pageSize,
              String gradeName

    ){
        // 分页 带条件查询
        Page<Grade> page =new Page<>(pageNo,pageSize);
        // 通过服务层
        IPage<Grade> pageRs=gradeService.getGradeByOpr(page,gradeName);

        // 封装Result对象并返回
        return Result.ok(pageRs);
    }
}
