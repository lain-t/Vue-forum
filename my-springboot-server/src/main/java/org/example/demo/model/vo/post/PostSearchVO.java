package org.example.demo.model.vo.post;

import lombok.Data;

import java.util.Date;

@Data
public class PostSearchVO {
    private int id;
    private String title;
    private String author;
    private Date time; // 发布时间
}
