package com.onlineexam.demo.mapper.score;

import com.onlineexam.demo.entity.score.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ScoreMapper {

    public boolean addScore(@Param("score") Score score) throws Exception;


    public boolean deleteScore(@Param("scoreId") int scoreId) throws Exception;


    public List<Score> queryScoreByUser(@Param("userId") int userId) throws Exception;


    public List<Score> queryScoreByPaper(@Param("paperId") int paperId) throws Exception;

}
