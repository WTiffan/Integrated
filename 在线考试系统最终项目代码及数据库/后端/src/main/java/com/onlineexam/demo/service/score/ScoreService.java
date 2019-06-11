package com.onlineexam.demo.service.score;

import com.onlineexam.demo.entity.score.Score;

import java.util.List;


public interface ScoreService {


    public boolean addScore(Score score) throws Exception;


    public List<Score> queryScoreByUser(int userId) throws Exception;


    public List<Score> queryScoreByPaper(int paperId) throws Exception;

}
