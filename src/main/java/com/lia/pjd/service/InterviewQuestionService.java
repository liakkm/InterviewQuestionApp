package com.lia.pjd.service;

import com.lia.pjd.dao.InterviewQuestionStorage;
import com.lia.pjd.dao.inmemory.InMemoryInterviewQuestionStorage;
import com.lia.pjd.dto.InterviewQuestionDto;
import com.lia.pjd.model.InterviewQuestionEntity;
import com.lia.pjd.service.mapper.InterviewQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterviewQuestionService {
    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionStorage storage;

    public InterviewQuestionService(InterviewQuestionMapper interviewQuestionMapper, InterviewQuestionStorage storage){
        this.interviewQuestionMapper = interviewQuestionMapper;
        this.storage = storage;
    }

    public List<InterviewQuestionDto> getAll(){
        return storage.getAll().stream()
                .map(interviewQuestionMapper::toInterviewQuestionDto)
                .toList();
    }

    public void createInterviewQuestion(InterviewQuestionDto interviewQuestion){
        storage.createInterviewQuestion(interviewQuestionMapper.toInterviewQuestion(interviewQuestion));
    }
}
