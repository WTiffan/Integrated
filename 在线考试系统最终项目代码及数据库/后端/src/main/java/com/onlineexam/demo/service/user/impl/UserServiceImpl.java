package com.onlineexam.demo.service.user.impl;

import com.onlineexam.demo.entity.user.User;
import com.onlineexam.demo.mapper.user.UserMapper;
import com.onlineexam.demo.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public List<User> checkPassword(String username, String password) throws Exception{
        boolean flag = true;
        List<User> list = userMapper.checkPassword(username,password);
        return list;
    }


    @Override
    public List<User> listAllUser() throws Exception{
        List<User> userList = Collections.emptyList();
        userList = userMapper.listAllUser();
        return userList;
    }


    @Override
    public boolean addUser(User user) throws Exception {

        return userMapper.addUser(user);

    }


    @Override
    public boolean deleteUser(int userId) throws Exception{
        return userMapper.deleteUser(userId);
    }




    @Override
    public boolean updatePower(int userId) throws Exception{
        return userMapper.updatePower(userId);
    }


    @Override
    public User queryByName(String username) throws Exception {
        return userMapper.querytByName(username);
    }


    @Override
    public User queryIdByUsername(String username) throws Exception {
        User userId = userMapper.queryIdByUsername(username);
        return userId;
    }


    @Override
    public List<User> listUserById(int userId) throws Exception{
        List<User> userList = Collections.emptyList();
        userList = userMapper.listUserById(userId);
        return userList;
    }
}
