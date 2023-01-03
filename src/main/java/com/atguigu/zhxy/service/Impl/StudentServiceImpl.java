package com.atguigu.zhxy.service.Impl;

import com.atguigu.zhxy.mapper.StudentMapper;
import com.atguigu.zhxy.pojo.Admin;
import com.atguigu.zhxy.pojo.Clazz;
import com.atguigu.zhxy.pojo.LoginForm;
import com.atguigu.zhxy.pojo.Student;
import com.atguigu.zhxy.service.StudentService;
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
 * @create 2022-12-28-20:23
 */
@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Student student = baseMapper.selectOne(queryWrapper);
        return student;
    }

    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Student> getStudentByOpr(Page<Student> pageParam, Student student) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper();
        String clazzName=student.getClazzName();
        if (!StringUtils.isEmpty(clazzName)) {
            queryWrapper.like("clazz_name",clazzName);
        }
        String name=student.getName();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.orderByDesc("id");

        Page<Student> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
