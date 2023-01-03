package com.atguigu.zhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nie
 * @create 2022-12-28-19:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_clazz")
public class Clazz {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;   // 班级id
    private String name;   //班级名字
    private Integer number;   //班级号
    private String introducation;   //班级介绍
    private String headmaster;   //班主任
    private String email;   //邮箱
    private long telephone;  //电话号
    private String gradeName;   //年纪号
}
