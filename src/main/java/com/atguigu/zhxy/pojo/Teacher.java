package com.atguigu.zhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nie
 * @create 2022-12-28-19:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_teacher")
public class Teacher {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;  //老师id
    private Integer tno;  //老师编号
    private String name;   //姓名
    private char gender;   //性别
    private String password;   //密码
    private String email;    //邮箱
    private long telephone;   //手机号
    private String address;  //地址
    private String portraitPath;  //头像
    private String clazzName;   //几年级
}
