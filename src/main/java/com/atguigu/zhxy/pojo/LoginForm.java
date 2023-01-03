package com.atguigu.zhxy.pojo;

import lombok.Data;

/**
 * @author nie
 * @create 2022-12-28-19:39
 */
@Data
public class LoginForm {
    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;
}
