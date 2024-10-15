package org.example.demo.model.dto.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserRegisterDTO {
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String phone;
}
