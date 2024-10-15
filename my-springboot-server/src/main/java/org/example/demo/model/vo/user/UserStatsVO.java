package org.example.demo.model.vo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("users")
public class UserStatsVO {
    private Long id;
    private String username;
    private String nickname;
    private Integer postCount; // 发帖数量
    private Integer commentCount; // 评论数量
    private Date lastLogin; // 最后登录时间
}
