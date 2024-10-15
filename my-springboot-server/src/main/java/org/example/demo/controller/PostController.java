package org.example.demo.controller;

import org.example.demo.model.PostDO;
import org.example.demo.service.PostService;
import org.example.demo.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

//@Controller
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService = new PostServiceImpl();

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody PostDO postDO) {
        try {
            postService.savePost(postDO);
            return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during created", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/findpost")
    public ResponseEntity<?> findPost(@RequestBody int id) {
        System.out.println(id);
        try {
            PostDO postDO = postService.findPostById(id);
            return new ResponseEntity<>(postDO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during find", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody PostDO postDO) {
        try {
            postService.savePost(postDO);
            return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during update", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deletePost(@RequestBody int postId) {
        try {
            postService.deletePost(postId);
            return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during delete", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/page")
    public ResponseEntity<?> showPost(@RequestBody int postId) {
        try {
            PostDO postDO = postService.findPostById(postId);
            if (!Objects.isNull(postDO)) {
                return new ResponseEntity<>(postDO, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pages/show")
    public ResponseEntity<?> showPosts() {
        try {
            List<PostDO> postDOS = postService.findAllPosts();
            if (!Objects.isNull(postDOS)) {
                return new ResponseEntity<>(postDOS, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/pages/author")
    public ResponseEntity<?> showPostsByAuthor(@RequestBody String author) {
        try {
            List<PostDO> postDOS = postService.findPostByAuthor(author);
            System.out.println(postDOS);
            if (!Objects.isNull(postDOS)) {
                return new ResponseEntity<>(postDOS, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("notfound", HttpStatus.BAD_REQUEST);

        }
    }

}