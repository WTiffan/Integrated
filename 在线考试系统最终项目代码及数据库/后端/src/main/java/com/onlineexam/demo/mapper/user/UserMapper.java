package com.onlineexam.demo.mapper.user;

import com.onlineexam.demo.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {


    public List<User> checkPassword(@Param("username") String username, @Param("password") String password) throws Exception;


    public List<User> listAllUser() throws Exception;


    public boolean addUser(@Param("user") User user) throws Exception;


    public boolean deleteUser(@Param("userId") int userId) throws Exception;


    public boolean updateUser(@Param("user") User user) throws Exception;

    public boolean updatePower(@Param("userId") int userId) throws Exception;

    public User querytByName(@Param("username") String username) throws Exception;


    public User queryIdByUsername(@Param("username") String username) throws Exception;


    public List<User> listUserById(@Param("userId") int userId) throws Exception;



}
