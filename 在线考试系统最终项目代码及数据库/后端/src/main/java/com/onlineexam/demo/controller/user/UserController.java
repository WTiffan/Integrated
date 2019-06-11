package com.onlineexam.demo.controller.user;

import com.onlineexam.demo.entity.user.User;
import com.onlineexam.demo.service.user.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;




    @ResponseBody
    @RequestMapping("/login")

    public String login(String username, String password, HttpServletRequest request) throws Exception {
        if(userService.queryByName(username) != null){
            if(userService.checkPassword(username,password).size() != 0){
                HttpSession session = request.getSession();
                session.setAttribute("usernameSession",username);
                System.out.println("登录成功！");
            }else {
                System.out.println("您的密码有误！");
            }
        }else{
            System.out.println("用户名不存在，请去注册！");
        }
        return username;
    }



    @ResponseBody
    @RequestMapping("/register")
    public String register (String username, String password) throws Exception{
        if(userService.queryByName(username) == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPower(0);
            if(userService.addUser(user)){
                System.out.println("注册成功！");
            }
        }else{
            System.out.println("用户名已存在，请直接登录！");
        }
        return username;
    }


    @ResponseBody
    @RequestMapping("listAllUser")
    public List<User> listAllArticle(){
        List<User> userList = null;
        try {
            userList = userService.listAllUser();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }


    @ResponseBody
    @RequestMapping("/listUserById")
    public List<User> listUserById(HttpServletRequest request) throws Exception {
        List<User> userList = null;
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.queryIdByUsername(username).getUserId();
        userList = userService.listUserById(userId);
        return userList;
    }


    @RequestMapping("/exit")
    @ResponseBody
    public void exit(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.removeAttribute("usernameSession");
        System.out.println("退出成功");
    }


    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(String userIdStr) throws Exception{
        int userId = Integer.parseInt(userIdStr);
        userService.deleteUser(userId);
        System.out.println("删除成功");
    }





    @RequestMapping("/updatePower")
    @ResponseBody
    public void updatePower(String userIdStr) throws Exception {
        int userId = Integer.parseInt(userIdStr);
        userService.updatePower(userId);
        System.out.println("修改成功!");
    }

}
