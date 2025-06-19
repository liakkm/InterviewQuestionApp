package com.lia.pjd.objects;

import com.lia.pjd.cli.CommandLineInterface;
import com.lia.pjd.controller.InterviewQuestionController;
import com.lia.pjd.dao.InterviewQuestionStorage;
import com.lia.pjd.dao.inmemory.InMemoryInterviewQuestionStorage;
import com.lia.pjd.service.InterviewQuestionService;
import com.lia.pjd.service.mapper.InterviewQuestionMapper;

public class ObjectInitializer {
    private final InterviewQuestionStorage interviewQuestionStorage;
    private final InterviewQuestionMapper interviewQuestionMapper;
    private final InterviewQuestionService interviewQuestionService;
    private final InterviewQuestionController interviewQuestionController;
    private final CommandLineInterface commandLineInterface;

    public ObjectInitializer(){
        this.interviewQuestionStorage = new InMemoryInterviewQuestionStorage();
        this.interviewQuestionMapper = new InterviewQuestionMapper();
        this.interviewQuestionService = new InterviewQuestionService(interviewQuestionMapper, interviewQuestionStorage);
        this.interviewQuestionController = new InterviewQuestionController(interviewQuestionService);
        this.commandLineInterface = new CommandLineInterface(interviewQuestionController);
    }

    public void run(){
        commandLineInterface.init();
    }
}
