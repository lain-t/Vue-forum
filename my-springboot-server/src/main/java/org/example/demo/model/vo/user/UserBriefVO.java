package org.example.demo.model.vo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserBriefVO {
    private Long id;
    private String username;
    private String nickname;
    private String avatarUrl; // 用户头像URL
    private String status; // 用户状态，例如：活跃、禁用等
}
