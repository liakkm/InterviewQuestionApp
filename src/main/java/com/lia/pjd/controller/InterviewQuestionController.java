package com.lia.pjd.controller;

import com.lia.pjd.dto.InterviewQuestionDto;
import com.lia.pjd.service.InterviewQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class InterviewQuestionController {
    private InterviewQuestionService service;
    private InterviewQuestionDto interviewQuestionDto;

    public InterviewQuestionController(InterviewQuestionService interviewInterviewQuestionService) {
        this.service = interviewInterviewQuestionService;
    }

    public List<InterviewQuestionDto> getList(){
        return service.getAll();
    }

    public void addQuestion(InterviewQuestionDto interviewQuestionDto){
        service.createInterviewQuestion(interviewQuestionDto);
    }


}
