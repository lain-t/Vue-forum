package org.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.demo.convert.UserConvert;
import org.example.demo.mapper.UserMapper;
import org.example.demo.model.UserDO;
import org.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;

    @Override
    public UserDO SelectUser(String username) {
        return userMapper.selectOne(new QueryWrapper<UserDO>().eq("username", username));
    }
    @Override
    public UserDO VerifyUser(String username, String password) {
            return userMapper.selectOne(
                    new QueryWrapper<UserDO>()
                            .eq("username", username)
                            .eq("password", password));
    }
    @Override
    public void saveUser(UserDO userDO) {
        if (userMapper.selectCount(new QueryWrapper<UserDO>().eq("username", userDO.getUsername())) > 0) {
            userMapper.updateById(userDO);
        } else {
            userMapper.insert(userDO);
        }
    }
    @Override
    public void deleteUser(int id) {
        userMapper.deleteById(id);
    }


//    public void registerUser(UserDO userDO) {
//        // 这里可以添加业务逻辑，比如密码加密、验证邮箱格式等
//        String sql = "INSERT INTO users (username, password, date) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, userDO.getUsername(), userDO.getPassword(), userDO.getRegistrationDate());
//    }
//
//    @Override
//    public UserDO SelectUser(String username) {
//        String sql = "SELECT * FROM users WHERE username = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
//    }
//
//    @Override
//    public UserDO VerifyUser(String username, String password) {
//        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new UserRowMapper());
//    }
//
//    @Override
//    public void saveUser(UserDO userDO) {
//        String sql = "INSERT INTO users (username, password, date) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, userDO.getUsername(), userDO.getPassword(), userDO.getRegistrationDate());
//    }
//
//    @Override
//    public void updateUser(UserDO userDO) {
//        String sql = "UPDATE users SET password = ?, date = ? WHERE username = ?";
//        jdbcTemplate.update(sql, userDO.getPassword(), userDO.getRegistrationDate(), userDO.getUsername());
//    }
//
//    @Override
//    public void deleteUser(UserDO userDO) {
//        String sql = "DELETE FROM users WHERE username = ?";
//        jdbcTemplate.update(sql, userDO.getUsername());
//    }
//
//    @Override
//    public void setAllSettings(UserDO userDO) {
//        try {
//            String sql = "UPDATE users SET username = ?, password = ?, email = ?, gender = ?, birthday = ?, phone = ?, introduction = ? WHERE username = ?";
//            jdbcTemplate.update(sql, userDO.getUsername(), userDO.getPassword(), userDO.getEmail(), userDO.getGender(), userDO.getBirthday(), userDO.getPhone(), userDO.getIntroduction(), userDO.getUsername());
//        } catch (DataAccessException e) {
//            System.out.println("DataAccessException: " + e.getMessage());
//        }
//    }
}