package com.atguigu.zhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nie
 * @create 2022-12-27-16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_admin")
public class Admin {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id; //用户id
    private String name; //用户姓名
    private char gender;  //性别
    private String password;   //密码
    private String email;   //邮箱
    private long telephone;  //电话号
    private String address;   //地址
    private String portrait_path;   //头像

}
