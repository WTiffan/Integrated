package com.onlineexam.demo.controller.notice;

import com.onlineexam.demo.entity.notice.Notice;
import com.onlineexam.demo.service.notice.NoticeService;
import com.onlineexam.demo.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("/addNotice")
    public void addNotice(String title, String content, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            String username = String.valueOf(session.getAttribute("usernameSession"));
            int userId = userService.queryIdByUsername(username).getUserId();

            Notice notice = new Notice();

            notice.setUserId(userId);
            notice.setTitle(title);
            notice.setContent(content);
            Date date = new Date();
            String createTimeStr = date.toString();
            notice.setCreateTime(createTimeStr);

            noticeService.addNotice(notice);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("增加公告失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/listAllNotice")
    public List<Notice> listAllNotice(){
        List<Notice> noticeList = null;
        try {
            noticeList = noticeService.listAllNotice();
        }catch (Exception e){
            e.printStackTrace();
        }
        return noticeList;
    }










}
