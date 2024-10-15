package org.example.demo.model.vo.post;

import lombok.Data;

@Data
public class PostSummaryVO {
    private int id;
    private String title;
    private String author;
    private String time; // 发布时间
    private int commentCount; // 评论数量
    private int likeCount; // 点赞数量
}
