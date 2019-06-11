package com.onlineexam.demo.controller.paper;

import com.onlineexam.demo.entity.paper.PaperDetail;
import com.onlineexam.demo.service.paper.PaperDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/paperDetail")
public class PaperDetailController {

    @Resource
    PaperDetailService paperDetailService;


    @ResponseBody
    @RequestMapping("/listAllPaperDetail")
    public List listAllPaperDetail(){
        List paperDetailList = new ArrayList<>();
        try {
            paperDetailList = paperDetailService.listAllPaperDetail();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paperDetailList;
    }


    @ResponseBody
    @RequestMapping("/listPaperDetailByPaperId")
    public List listPaperDetailByPaperId(String paperIdStr){
        int paperId = Integer.parseInt(paperIdStr);
        List paperDetailList = new ArrayList<>();

        try {
            paperDetailList = paperDetailService.listPaperDetailByPaperId(paperId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return paperDetailList;
    }


    @ResponseBody
    @RequestMapping("/addPaperDetail")
        public void addPaperDetail(String paperIdStr, String exerciseTypeStr, String exerciseIdStr, String contentStr, String typeAStr, String typeBStr, String typeCStr, String typeDStr, String answerStr, String scoreStr) throws Exception{

        PaperDetail paperDetail = new PaperDetail();

        int score = Integer.parseInt(scoreStr);
        int exerciseType = Integer.parseInt(exerciseTypeStr);
        int paperId = Integer.parseInt(paperIdStr);
        int exerciseId = Integer.parseInt(exerciseIdStr);

        paperDetail.setPaperId(paperId);
        paperDetail.setExerciseId(exerciseId);
        paperDetail.setContent(contentStr);

        if(exerciseType == 0){
            paperDetail.setTypeA(typeAStr);
            paperDetail.setTypeB(typeBStr);
            paperDetail.setTypeC(typeCStr);
            paperDetail.setTypeD(typeDStr);
            paperDetail.setExerciseType("单选题");
        }else if(exerciseType == 1){
            paperDetail.setTypeA(typeAStr);
            paperDetail.setTypeB(typeBStr);
            paperDetail.setTypeC(typeCStr);
            paperDetail.setTypeD(typeDStr);
            paperDetail.setExerciseType("多选题");
        }else{
            paperDetail.setTypeA(typeAStr);
            paperDetail.setTypeB(typeBStr);
            paperDetail.setExerciseType("判断题");
        }

        paperDetail.setAnswer(answerStr);
        paperDetail.setScore(score);

        paperDetailService.addPaperDetail(paperDetail);

    }







    @ResponseBody
    @RequestMapping("queryPaperDetail")
    public List queryPaperDetail(String keyStr) throws Exception {
        List<PaperDetail> paperDetailList = new ArrayList<>();
        paperDetailList = paperDetailService.queryPaperDetail(keyStr);
        return paperDetailList;
    }




}
