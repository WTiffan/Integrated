package com.onlineexam.demo.service.notice.impl;

import com.onlineexam.demo.entity.notice.Notice;
import com.onlineexam.demo.mapper.notice.NoticeMapper;
import com.onlineexam.demo.service.notice.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    NoticeMapper noticeMapper;


    @Override
    public List<Notice> listAllNotice() throws Exception{
        List<Notice> noticeList = Collections.emptyList();
        noticeList = noticeMapper.listAllNotice();
        return noticeList;
    }

    @Override
    public boolean addNotice(Notice notice) throws Exception {
        if(noticeMapper.addNotice(notice)){
            return true;
        }else {
            return false;
        }
    }


}
