package org.example.demo.model.dto.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserEditDTO {
    private Long id;
    private String username;
    private String nickname;
    private String newPassword; // 新密码
    private String confirmNewPassword; // 确认新密码
    private String email;
    private String phone;
}
