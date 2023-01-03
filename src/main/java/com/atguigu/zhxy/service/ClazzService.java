package com.atguigu.zhxy.service;

import com.atguigu.zhxy.pojo.Clazz;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author nie
 * @create 2022-12-28-20:14
 */
public interface ClazzService extends IService<Clazz> {
    IPage<Clazz> getClazzsByOpr(Page<Clazz> page, Clazz clazz);

    List<Clazz> getClazzs();
}
