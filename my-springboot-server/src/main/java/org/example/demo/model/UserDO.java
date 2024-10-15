package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName("users")
public class UserDO {
    private int id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String gender;
    private Date birthday;
    private String phone;
    private String introduction;
    private String avatar;
    @TableField(value = "date", fill = FieldFill.INSERT)
    private Date registrationDate; // 用户注册日期
}