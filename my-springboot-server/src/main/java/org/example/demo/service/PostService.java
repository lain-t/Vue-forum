package org.example.demo.service;

import org.example.demo.model.PostDO;
import java.util.List;

public interface PostService {
    void deletePost(int id);
    PostDO findPostById(int id);
    List<PostDO> findPostByAuthor(String author);
    PostDO findPostByTitle(String title);
    List<PostDO> findAllPosts();
    void savePost(PostDO postDO);
}
