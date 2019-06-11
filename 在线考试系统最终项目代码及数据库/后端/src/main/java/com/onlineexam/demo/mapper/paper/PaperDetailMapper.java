package com.onlineexam.demo.mapper.paper;

import com.onlineexam.demo.entity.paper.PaperDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface PaperDetailMapper {


    public List<PaperDetail> listAllPaperDetail() throws Exception;

    public List<PaperDetail> listPaperDetailByPaperId(@Param("paperId") int paperId) throws Exception;


    public boolean addPaperDetail(@Param("paperDetail") PaperDetail paperDetail) throws Exception;


    public boolean deletePaperDetail(@Param("paperDetailId") int paperDetailId) throws Exception;


    public boolean updatePaperDetail(@Param("paperDetail") PaperDetail paperDetail) throws Exception;


    public List<PaperDetail> queryPaperDetail(@Param("keyWord") String keyWord) throws Exception;


    public List<PaperDetail> queryExerciseByTypes(@Param("exerciseType") String exerciseType) throws Exception;


    public List<PaperDetail> queryExerciseItemsById(@Param("paperDetailId") int paperDetailId) throws Exception;

}
