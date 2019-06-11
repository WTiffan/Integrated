package com.onlineexam.demo.service.paper.impl;

import com.onlineexam.demo.entity.paper.Paper;
import com.onlineexam.demo.mapper.paper.PaperMapper;
import com.onlineexam.demo.service.paper.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class PaperServiceImpl implements PaperService {

    @Resource
    PaperMapper paperMapper;


    @Override
    public List<Paper> listAllPaper() throws Exception{
        List<Paper> paperList = Collections.emptyList();
        paperList = paperMapper.listAllPaper();
        return paperList;
    }


    @Override
    public boolean addPaper(Paper paper) throws Exception {
        if(paperMapper.addPaper(paper)){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean deletePaper(int paperId) throws Exception{
        return paperMapper.deletePaper(paperId);
    }


    @Override
    public boolean updatePaper(Paper paper) throws Exception{
        return paperMapper.updatePaper(paper);
    }


    @Override
    public List<Paper> queryPaperName(String keyWord) throws Exception{
        List<Paper> paperlist = Collections.emptyList();
        keyWord = "%" + keyWord + "%";
        paperlist = paperMapper.queryPaperName(keyWord);
        return paperlist;
    }


    @Override
    public Paper queryPaperNameById(int paperId) throws Exception{
        return paperMapper.queryPaperNameById(paperId);
    }

}
