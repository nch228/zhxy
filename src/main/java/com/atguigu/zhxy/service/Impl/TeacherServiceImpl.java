package com.atguigu.zhxy.service.Impl;

import com.atguigu.zhxy.mapper.TeacherMapper;
import com.atguigu.zhxy.pojo.LoginForm;
import com.atguigu.zhxy.pojo.Student;
import com.atguigu.zhxy.pojo.Teacher;
import com.atguigu.zhxy.service.TeacherService;
import com.atguigu.zhxy.util.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author nie
 * @create 2022-12-28-20:24
 */
@Service("teacherServiceImpl")
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Teacher teacher = baseMapper.selectOne(queryWrapper);
        return teacher;
    }

    @Override
    public Teacher getTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Teacher> getTeachers(Page<Teacher> pageParam, Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper();
        String clazzName=teacher.getClazzName();
        if (!StringUtils.isEmpty(clazzName)) {
            queryWrapper.like("clazz_name",clazzName);
        }
        String name=teacher.getName();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.orderByDesc("id");

        Page<Teacher> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}