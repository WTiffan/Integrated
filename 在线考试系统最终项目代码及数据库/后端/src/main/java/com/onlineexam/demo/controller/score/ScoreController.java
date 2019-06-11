package com.onlineexam.demo.controller.score;

import com.onlineexam.demo.entity.score.Score;
import com.onlineexam.demo.service.paper.PaperService;
import com.onlineexam.demo.service.score.ScoreService;
import com.onlineexam.demo.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Resource
    ScoreService scoreService;

    @Resource
    UserService userService;

    @Resource
    PaperService paperService;


    @ResponseBody
    @RequestMapping("/queryScoreByUser")
    public List<Score> queryScoreByUser(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.queryIdByUsername(username).getUserId();

        List<Score> scoreList = null;
        try {
            scoreList = scoreService.queryScoreByUser(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return scoreList;
    }

    @ResponseBody
    @RequestMapping("/addScore")
    public void addExam(String paperIdStr, String markStr, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.queryIdByUsername(username).getUserId();

        int paperId = Integer.parseInt(paperIdStr);
        int mark = Integer.parseInt(markStr);

        String paperName = paperService.queryPaperNameById(paperId).getPaperName();
        Score score = new Score();
        score.setUserId(userId);
        score.setPaperId(paperId);
        score.setMark(mark);
        score.setPaperName(paperName);

        scoreService.addScore(score);

    }

    @ResponseBody
    @RequestMapping("/queryScoreByPaper")
    public List<Score> queryScoreByPaper(String paperIdStr) throws Exception {
        int paperId = Integer.parseInt(paperIdStr);
        List<Score> scoreList = null;
        try {
            scoreList = scoreService.queryScoreByPaper(paperId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return scoreList;
    }




}
