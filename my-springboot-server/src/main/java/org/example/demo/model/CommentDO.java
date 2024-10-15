package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comments")
public class CommentDO {
    private int id;
    private int postId;
    private String author;
    private String content;
    private String time;
}
