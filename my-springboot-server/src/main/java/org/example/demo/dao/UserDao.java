package org.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.demo.mapper.UserMapper;
import org.example.demo.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDao {
    UserMapper userMapper;
    QueryWrapper<UserDO> quaryWrapper = new QueryWrapper<>();

    void registerUser(UserDO userDO){
        userMapper.insert(userDO);
    }
    void verifyUser(String username, String password){
        quaryWrapper.clear();
        quaryWrapper
                .eq("username", username)
                .eq("password", password);
        userMapper.selectOne(quaryWrapper);
    }
    UserDO findByUsername(String username){
        quaryWrapper.clear();
        quaryWrapper.eq("username", username);
        return userMapper.selectOne(quaryWrapper);
    }
    void updateUser(UserDO userDO){
        userMapper.updateById(userDO);
    }
    void deleteUser(UserDO userDO){
        userMapper.deleteById(userDO);
    }
}
