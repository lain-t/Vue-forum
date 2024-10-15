package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

//这里是使用Lombok的@Data注解，自动生成getter和setter方法
//使用mybatis-plus的@TableName注解，指定数据库表名

@Data
@Builder
@TableName("posts")
public class PostDO {
    private int id;           // 帖子ID
    private String title;     // 帖子标题
    private String author;    // 帖子作者
    private String content;   // 帖子内容
    @TableField(fill = FieldFill.INSERT)
    private Date date;        // 帖子发布时间
}
