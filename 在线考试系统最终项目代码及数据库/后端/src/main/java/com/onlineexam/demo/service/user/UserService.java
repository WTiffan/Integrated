package com.onlineexam.demo.service.user;

import com.onlineexam.demo.entity.user.User;

import java.util.List;


public interface UserService {


    public List<User> checkPassword(String username, String password) throws Exception;


    public List<User> listAllUser() throws Exception;


    public boolean addUser(User user) throws Exception;


    public boolean deleteUser(int userId) throws Exception;



    public boolean updatePower(int userId) throws Exception;


    public User queryByName(String username) throws Exception;


    public User queryIdByUsername(String username) throws Exception;


    public List<User> listUserById(int userId) throws Exception;

}
