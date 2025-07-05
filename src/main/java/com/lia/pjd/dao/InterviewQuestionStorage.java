package com.lia.pjd.dao;

import com.lia.pjd.model.InterviewQuestionEntity;

import java.util.List;

public interface InterviewQuestionStorage {
    void createInterviewQuestion(InterviewQuestionEntity interviewQuestion);

    List<InterviewQuestionEntity> getAll();
}
