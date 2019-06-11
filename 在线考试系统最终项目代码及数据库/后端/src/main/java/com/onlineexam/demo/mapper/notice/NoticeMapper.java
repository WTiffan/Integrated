package com.onlineexam.demo.mapper.notice;

import com.onlineexam.demo.entity.notice.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface NoticeMapper {


    public List<Notice> listAllNotice() throws Exception;


    public boolean addNotice(@Param("notice") Notice notice) throws Exception;


    public boolean deleteNotice(@Param("noticeId") int noticeId) throws Exception;


    public boolean updateNotice(@Param("notice") Notice notice) throws Exception;


    public List<Notice> queryNotice(@Param("keyWord") String keyWord) throws Exception;

}
