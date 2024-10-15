package org.example.demo.controller;

import org.example.demo.convert.UserConvert;
import org.example.demo.model.UserDO;
import org.example.demo.model.dto.user.UserVerifyDTO;
import org.example.demo.model.vo.user.UserDetailVO;
import org.example.demo.service.UserService;
import org.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

//@Controller
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();
    @Autowired
    private UserConvert userConvert;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserVerifyDTO userVerifyDTO) {
        try {
            UserDO mmm = UserDO.builder()
                    .username(userVerifyDTO.getUsername())
                    .password(userVerifyDTO.getPassword())
                    .build();
            userService.saveUser(mmm);
            UserDO userDO0 = userService.SelectUser(userVerifyDTO.getUsername());
            UserDetailVO userDetailVO = userConvert.userToDetailVO(userDO0);
            return new ResponseEntity<>(userDetailVO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during registration", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserVerifyDTO userVerifyDTO) {
        try {
            UserDO userDO0 = userService.VerifyUser(userVerifyDTO.getUsername(), userVerifyDTO.getPassword());
            UserDetailVO userDetailVO = userConvert.userToDetailVO(userDO0);
            if (Objects.isNull(userDetailVO)) {
                return new ResponseEntity<>("用户名或密码错误", HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>(userDetailVO, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during registration", HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/delete")
//    public ResponseEntity<?> deleteUser(@RequestBody UserDO userDO) {
//        try {
//            userService.deleteUser(userDO);
//            return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error occurred during registration", HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody UserDO userDO) {
        try {
            userService.saveUser(userDO);
            UserDO userDO1 = userService.SelectUser(userDO.getUsername());
            return new ResponseEntity<>(userDO1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred during registration", HttpStatus.BAD_REQUEST);
        }
    }
}
