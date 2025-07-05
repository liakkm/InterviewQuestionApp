package com.lia.pjd.model;

import java.util.Objects;


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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InterviewQuestionEntity that = (InterviewQuestionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }
}
