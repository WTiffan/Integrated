package com.onlineexam.demo.entity.paper;


public class PaperDetail {


    private Integer paperDetailId;


    private Integer paperId;


    private Integer exerciseId;


    private String content;


    private String typeA;


    private String typeB;


    private String typeC;


    private String typeD;


    private String answer;


    private String exerciseType;


    private Integer score;


    private String paperName;

    public Integer getPaperDetailId() {
        return paperDetailId;
    }

    public void setPaperDetailId(Integer paperDetailId) {
        this.paperDetailId = paperDetailId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getTypeD() {
        return typeD;
    }

    public void setTypeD(String typeD) {
        this.typeD = typeD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    @Override
    public String toString() {
        return "PaperDetail{" +
                "paperDetailId=" + paperDetailId +
                ", paperId=" + paperId +
                ", exerciseId=" + exerciseId +
                ", content='" + content + '\'' +
                ", typeA='" + typeA + '\'' +
                ", typeB='" + typeB + '\'' +
                ", typeC='" + typeC + '\'' +
                ", typeD='" + typeD + '\'' +
                ", answer='" + answer + '\'' +
                ", exerciseType='" + exerciseType + '\'' +
                ", score=" + score +
                ", paperName='" + paperName + '\'' +
                '}';
    }
}
