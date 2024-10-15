package org.example.demo.model.vo.post;

import lombok.Data;

import java.util.Date;

@Data
public class PostStatsVO {
    private int id;
    private int viewCount; // 浏览次数
    private int commentCount; // 评论数量
    private int likeCount; // 点赞数量
    private Date time; // 发布时间
}
