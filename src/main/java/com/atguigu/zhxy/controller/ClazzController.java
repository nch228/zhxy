package com.atguigu.zhxy.controller;

import com.atguigu.zhxy.pojo.Clazz;
import com.atguigu.zhxy.pojo.Grade;
import com.atguigu.zhxy.service.ClazzService;
import com.atguigu.zhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nie
 * @create 2022-12-28-20:29
 */
@RestController
@RequestMapping("sms/clazzController")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;



    @GetMapping("getClazzs")
    public Result getClazzs(){
        List<Clazz>  clazzs=clazzService.getClazzs();
        return Result.ok(clazzs);
    }

    @DeleteMapping("/deleteClazz")
    public Result deleteClazz(
            @RequestBody List<Integer> ids
    ){
        clazzService.removeByIds(ids);
        return Result.ok();
    }

    @PostMapping("/saveOrUpdateClazz")
    public Result saveOrUpdateClazz(
            @RequestBody Clazz clazz
    ){
        //接收参数
        //调用服务层方法完成增减或者修改
        clazzService.saveOrUpdate(clazz);
        return Result.ok();
    }

    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result getClazzByOpr(
             @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
             Clazz clazz
    ){
        Page<Clazz> page =new Page<>(pageNo,pageSize);

        IPage<Clazz> iPage=clazzService.getClazzsByOpr(page,clazz);

        return Result.ok(iPage);

    }
}
