package org.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

@Data
@TableName("categorys")
public class CategoryDO {
    private int id;
    private int postCount;
    private String name;
    private String description;
    private Date time;
    private Date lastPostTime;
}
