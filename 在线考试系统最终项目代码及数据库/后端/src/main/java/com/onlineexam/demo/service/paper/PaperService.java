package com.onlineexam.demo.service.paper;

import com.onlineexam.demo.entity.paper.Paper;

import java.util.List;


public interface PaperService {


    public List<Paper> listAllPaper() throws Exception;


    public boolean addPaper(Paper paper) throws Exception;


    public boolean deletePaper(int paperId) throws Exception;


    public boolean updatePaper(Paper paper) throws Exception;

    public List<Paper> queryPaperName(String keyWord) throws Exception;

    public Paper queryPaperNameById(int paperId) throws Exception;

}
