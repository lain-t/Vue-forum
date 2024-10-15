package org.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.demo.convert.PostConvert;
import org.example.demo.mapper.PostMapper;
import org.example.demo.model.PostDO;
import org.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostConvert postConvert;

    @Override
    public void savePost(PostDO postDO) {
        if (postMapper.selectCount(new QueryWrapper<PostDO>().eq("id", postDO.getId())) > 0) {
            postMapper.updateById(postDO);
        } else {
            postMapper.insert(postDO);
        }
    }
    @Override
    public PostDO findPostById(int id) {
        return postMapper.selectById(id);
    }
    @Override
    public List<PostDO> findPostByAuthor(String author) {
        return postMapper.selectList(new QueryWrapper<PostDO>().eq("author", author));
    }
    @Override
    public PostDO findPostByTitle(String title) {
        return postMapper.selectOne(new QueryWrapper<PostDO>().eq("title", title));
    }
    @Override
    public List<PostDO> findAllPosts() {
        return postMapper.selectList(null);
    }
    @Override
    public void deletePost(int id) {
        postMapper.deleteById(id);
    }



//    @Override
//    public void createPost(PostDO postDO) {
//        String sql = "INSERT INTO posts (title, author, content, time) VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sql, postDO.getTitle(), postDO.getAuthor(), postDO.getContent(), postDO.getTime());
//    }
//
//    @Override
//    public void updatePost(PostDO postDO) {
//        String sql = "UPDATE posts SET title = ?, author = ?, content = ?, time = ? WHERE title = ?";
//        jdbcTemplate.update(sql, postDO.getTitle(), postDO.getAuthor(), postDO.getContent(), postDO.getTime(), postDO.getTitle());
//    }
//
//    @Override
//    public void deletePost(int id) {
//        String sql = "DELETE FROM posts WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    @Override
//    public PostDO findPostById(int id) {
//        String sql = "SELECT * FROM posts WHERE id = ?";
//        try {
//            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PostRowMapper());
//        } catch (DataAccessException e) {
//            System.out.println("DataAccessException: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public List<PostDO> findPostByAuthor(String author) {
//        String sql = "SELECT * FROM posts WHERE author = ?";
//        try {
//            return jdbcTemplate.query(sql, new Object[]{author}, new PostRowMapper());
//        }catch (DataAccessException e){
//            System.out.println("DataAccessException: " + e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public PostDO findPostByTitle(String title) {
//        String sql = "SELECT * FROM posts WHERE title = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{title}, new PostRowMapper());
//    }
//
//    @Override
//    public List<PostDO> findAllPosts() {
//        String sql = "SELECT * FROM posts";
//        return jdbcTemplate.query(sql, new PostRowMapper());
//    }
}
