package com.lia.pjd.model;

import lombok.Data;

import java.util.Objects;

@Data
public class InterviewQuestionEntity {
    private Long id;
    private String question;
    private String answer;

    public InterviewQuestionEntity(String question, String answer, Long id){
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public InterviewQuestionEntity(String question, String answer){
        this.question = question;
        this.answer = answer;
        this.id = null;
    }


}
