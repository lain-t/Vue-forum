package org.example.demo.model.vo.post;

import lombok.Data;

@Data
public class PostDetailVO {
    private int id;
    private String title;
    private String content;
    private String author;
    private String time; // 发布时间
    private String lastEditTime; // 最后编辑时间
    private int viewCount; // 浏览次数
    private int commentCount; // 评论数量
    private int likeCount; // 点赞数量
    private boolean isLiked; // 是否已点赞
    private boolean isFavorited; // 是否已收藏

}
