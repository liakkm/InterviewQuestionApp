package com.lia.pjd.service.mapper;

import com.lia.pjd.dto.InterviewQuestionDto;
import com.lia.pjd.model.InterviewQuestionEntity;

public class InterviewQuestionMapper {
    public InterviewQuestionEntity toInterviewQuestion(InterviewQuestionDto interviewQuestionDto){
        return new InterviewQuestionEntity(interviewQuestionDto.getQuestion(), interviewQuestionDto.getAnswer());
    }

    public InterviewQuestionDto toInterviewQuestionDto(InterviewQuestionEntity interviewQuestion){
        return new InterviewQuestionDto(interviewQuestion.getId(),
                                        interviewQuestion.getQuestion(),
                                        interviewQuestion.getAnswer());
    }
}
