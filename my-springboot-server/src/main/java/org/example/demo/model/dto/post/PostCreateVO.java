package org.example.demo.model.dto.post;

import lombok.Data;

import java.sql.Date;

@Data
public class PostCreateVO {
    private String title;
    private String content;
    private String author;
    private Date date;
}
