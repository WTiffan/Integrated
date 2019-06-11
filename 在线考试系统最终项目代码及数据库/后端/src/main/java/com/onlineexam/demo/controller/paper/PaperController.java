package com.onlineexam.demo.controller.paper;

import com.onlineexam.demo.entity.paper.Paper;
import com.onlineexam.demo.service.paper.PaperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin(allowCredentials = "true")
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Resource
    PaperService paperService;


    @RequestMapping("/listAllPaper")
    @ResponseBody
    public List<Paper> listAllPaper(){
        List<Paper> paperList = null;
        try {
            paperList = paperService.listAllPaper();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paperList;
    }


    @ResponseBody
    @RequestMapping("/addPaper")
    public void addPaper(String paperName){
        try {
            Paper paper = new Paper();
            paper.setPaperName(paperName);
            paperService.addPaper(paper);
        }catch (Exception e){
            e.printStackTrace();

        }
    }


    @ResponseBody
    @RequestMapping("/deletePaper")
    public void deletePaper(String paperIdStr) {
        int paperId = Integer.parseInt(paperIdStr);
        try {
            paperService.deletePaper(paperId);
        }catch (Exception e){
            e.printStackTrace();

        }
    }


    @ResponseBody
    @RequestMapping("/updatePaper")
    public void updatePaper(String paperIdStr, String paperName) {
        int paperId = Integer.parseInt(paperIdStr);
        try {
            Paper paper = new Paper();

            paper.setPaperId(paperId);
            paper.setPaperName(paperName);
            paperService.updatePaper(paper);
        }catch (Exception e){
            e.printStackTrace();

        }
    }


    @ResponseBody
    @RequestMapping("/queryPaperName")
    public List<Paper> queryPaperName(String keyStr){
        List<Paper> paperList = null;
        try {
            paperList = paperService.queryPaperName(keyStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return paperList;
    }
}
