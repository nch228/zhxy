package com.atguigu.zhxy.service.Impl;

import com.atguigu.zhxy.mapper.ClazzMapper;
import com.atguigu.zhxy.pojo.Clazz;
import com.atguigu.zhxy.pojo.Grade;
import com.atguigu.zhxy.service.ClazzService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author nie
 * @create 2022-12-28-20:15
 */
@Service("clazzServiceImpl")
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Override
    public IPage<Clazz> getClazzsByOpr(Page<Clazz> pageParam, Clazz clazz) {
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper();
        String gradeName=clazz.getGradeName();
        if (!StringUtils.isEmpty(gradeName)) {
            queryWrapper.like("grade_name",gradeName);
        }
        String name=clazz.getName();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.orderByDesc("id");

        Page<Clazz> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }

    @Override
    public List<Clazz> getClazzs() {
        return baseMapper.selectList(null);
    }
}
