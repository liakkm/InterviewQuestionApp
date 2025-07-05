package com.lia.pjd.dao.inmemory;

import com.lia.pjd.dao.InterviewQuestionStorage;
import com.lia.pjd.model.InterviewQuestionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class InMemoryInterviewQuestionStorage implements InterviewQuestionStorage {
    private final AtomicLong lastIdentifier;
    private final Map<Long, InterviewQuestionEntity> storage;

    public InMemoryInterviewQuestionStorage() {
        lastIdentifier = new AtomicLong(0);
        storage = new ConcurrentHashMap<>();
    }

    @Override
    public void createInterviewQuestion(InterviewQuestionEntity question) {
        Long id = generateId();
        InterviewQuestionEntity interviewQuestion = new InterviewQuestionEntity(question.getQuestion(),
                                                                                question.getAnswer(),
                                                                                id);
        storage.put(id, interviewQuestion);
    }

    @Override
    public List<InterviewQuestionEntity> getAll() {
        return new ArrayList<>(storage.values());
    }

    private Long generateId(){
        return lastIdentifier.addAndGet(1L);
    }
}
