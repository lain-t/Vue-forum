package org.example.demo.model.vo.user;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class UserDetailVO {
    private int id;
    private String username;
    private String nickname;
    private String email;
    private String gender;
    private Date birthday;
    private String phone;
    private String introduction;
    private String avatar;
    private Date registrationDate; // 用户注册日期
}
