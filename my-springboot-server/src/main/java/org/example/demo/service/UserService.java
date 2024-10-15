package org.example.demo.service;


import org.example.demo.model.UserDO;

public interface UserService {
    UserDO SelectUser(String username);
    UserDO VerifyUser(String username, String password);
    void saveUser(UserDO userDO);
    void deleteUser(int id);
}