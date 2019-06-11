package com.onlineexam.demo.mapper.paper;

import com.onlineexam.demo.entity.paper.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PaperMapper {


     List<Paper> listAllPaper() throws Exception;


    public boolean addPaper(@Param("paper") Paper paper) throws Exception;


    public boolean deletePaper(@Param("paperId") int paperId) throws Exception;


    public boolean updatePaper(@Param("paper") Paper paper) throws Exception;


    public List<Paper> queryPaperName(@Param("keyWord") String keyWord) throws Exception;


    public Paper queryPaperNameById(@Param("paperId") int paperId) throws Exception;

}
