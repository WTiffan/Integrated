package com.onlineexam.demo.service.paper;


import com.onlineexam.demo.entity.paper.PaperDetail;

import java.util.List;


public interface PaperDetailService {


    public List<PaperDetail> listAllPaperDetail() throws Exception;


    public List<PaperDetail> listPaperDetailByPaperId(int paperId) throws Exception;


    public boolean addPaperDetail(PaperDetail paperDetail) throws Exception;



    public List<PaperDetail> queryPaperDetail(String keyWord) throws Exception;


}
