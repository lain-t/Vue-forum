package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("friendships")
public class FriendshipDO {
    private int id;
    private int userId1;
    private int userId2;
    private boolean confirmed;
}
