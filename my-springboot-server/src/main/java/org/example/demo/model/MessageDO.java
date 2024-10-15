package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("messages")
public class MessageDO {
    private int id;
    private int postId;
    private String author;
    private String content;
    private Date time;
}
