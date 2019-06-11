package com.onlineexam.demo.service.paper.impl;


import com.onlineexam.demo.entity.paper.PaperDetail;
import com.onlineexam.demo.mapper.paper.PaperDetailMapper;
import com.onlineexam.demo.service.paper.PaperDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class PaperDetailServiceImpl implements PaperDetailService {

    @Resource
    PaperDetailMapper paperDetailMapper;


    @Override
    public List<PaperDetail> listAllPaperDetail() throws Exception{
        List<PaperDetail> paperDetailList = Collections.emptyList();
        paperDetailList = paperDetailMapper.listAllPaperDetail();
        return paperDetailList;
    }


    @Override
    public List<PaperDetail> listPaperDetailByPaperId(int paperId) throws Exception{
        List<PaperDetail> paperDetailList = Collections.emptyList();
        paperDetailList = paperDetailMapper.listPaperDetailByPaperId(paperId);
        return paperDetailList;
    }


    @Override
    public boolean addPaperDetail(PaperDetail paperDetail) throws Exception {
        if(paperDetailMapper.addPaperDetail(paperDetail)){
            return true;
        }else {
            return false;
        }
    }






    @Override
    public List<PaperDetail> queryPaperDetail(String keyWord) throws Exception{
        List<PaperDetail> paperDetaillist = Collections.emptyList();
        keyWord = "%" + keyWord + "%";
        paperDetaillist = paperDetailMapper.queryPaperDetail(keyWord);
        return paperDetaillist;
    }





}
