package com.lia.pjd.cli;

import com.lia.pjd.controller.InterviewQuestionController;
import com.lia.pjd.dto.InterviewQuestionDto;
import com.lia.pjd.model.InterviewQuestionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class CommandLineInterface {
    public static final String DD_INTERVIEW_QUESTION_MENU_TEXT = """
                === Добавление интервью вопроса ===
                        введите текст вопроса
                    (для возврата введите "menu"):
            """;
    public static final String APP_MENU_TEXT = """
            Доступные комманды:
            
            1. list - показать все вопросы
            2. add - добавить вопрос
            3. exit - выйти
            
            Введите комманду:
            """;
    private static final String APP_WELCOME_TEXT = "WELCOME TO JAVA INTERVIEW QUESTION APP!";
    private InterviewQuestionController interviewQuestionController;

    public CommandLineInterface(InterviewQuestionController interviewQuestionController) {
        this.interviewQuestionController = interviewQuestionController;
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(APP_WELCOME_TEXT);
        CliCommands input;
        do {
            System.out.print(APP_MENU_TEXT);
            CliCommandParsingResult result = getInputFromCli(scanner);
            if(!result.successful){
                input = result.cliCommand;
                System.out.println(result.errorMessage);
            }
            else {
                input = result.cliCommand;
                switch (input) {
                    case LIST -> showListOfInterview();
                    case ADD -> addInterviewQuestion(scanner);
                }
            }
        } while (!input.equals(CliCommands.EXIT));
        System.out.println(123);
    }

    private void addInterviewQuestion(Scanner scanner){
        System.out.println(DD_INTERVIEW_QUESTION_MENU_TEXT);
        System.out.println("Введите вопрос:");
        String question = scanner.nextLine();
        String answer = "";
        try{
            if (CliCommands.valueOf(question.trim().toUpperCase()).equals(CliCommands.MENU))
                return;
        }
        catch (IllegalArgumentException e){
            System.out.println("Введите ответ:");
            answer = scanner.nextLine();
        }
        catch (NullPointerException e){
            System.out.println("Вы не ввели ответ");
        }
        try{
            if (CliCommands.valueOf(answer.trim().toUpperCase()).equals(CliCommands.MENU))
                return;
        }
        catch (IllegalArgumentException e){
            InterviewQuestionDto interviewQuestionDto = new InterviewQuestionDto(question, answer);
            interviewQuestionController.addQuestion(interviewQuestionDto);
        }
        catch (NullPointerException e){
            System.out.println("Вы не ввели ответ");
        }
    }

    private void showListOfInterview(){
        List<InterviewQuestionDto> interviewQuestionDtos = interviewQuestionController.getList();
        interviewQuestionDtos.forEach(System.out::println);
    }

    private CliCommandParsingResult getInputFromCli(Scanner scanner){
        CliCommands commands;
        try{
            String stringInput = scanner.nextLine().trim().toUpperCase();
            commands = CliCommands.valueOf(stringInput);
            return new CliCommandParsingResult(commands, true, null);
        }
        catch (IllegalArgumentException e){
            return new CliCommandParsingResult(CliCommands.UNRECOGNIZED, false, "Unrecognized CLI command");
        }
    }

    private record CliCommandParsingResult(
            CliCommands cliCommand,
            boolean successful,
            String errorMessage
    ){

    }
}
