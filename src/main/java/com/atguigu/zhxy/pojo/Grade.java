package com.atguigu.zhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nie
 * @create 2022-12-28-19:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_grade")
public class Grade {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;  //年纪id
    private String name;  //几年级
    private String manager;  //年级主任
    private String email;  //邮箱
    private long telephone;  //手机号
    private String introducation;   //介绍
}
