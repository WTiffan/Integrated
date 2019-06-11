package com.onlineexam.demo.service.notice;

import com.onlineexam.demo.entity.notice.Notice;

import java.util.List;


public interface NoticeService {


    public List<Notice> listAllNotice() throws Exception;


    public boolean addNotice(Notice notice) throws Exception;




}
