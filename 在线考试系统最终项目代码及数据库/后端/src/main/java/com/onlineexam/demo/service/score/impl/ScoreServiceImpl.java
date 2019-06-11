package com.onlineexam.demo.service.score.impl;

import com.onlineexam.demo.entity.score.Score;
import com.onlineexam.demo.mapper.score.ScoreMapper;
import com.onlineexam.demo.service.score.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    ScoreMapper scoreMapper;


    @Override
    public boolean addScore(Score score) throws Exception {
        if(scoreMapper.addScore(score)){
            return true;
        }else {
            return false;
        }
    }




    @Override
    public List<Score> queryScoreByUser(int userId) throws Exception{
        List<Score> scoreList = scoreMapper.queryScoreByUser(userId);
        return scoreList;
    }

    @Override
    public List<Score> queryScoreByPaper(int paperId) throws Exception{
        List<Score> scoreList = scoreMapper.queryScoreByPaper(paperId);
        return scoreList;
    }

}
