package com.lia.pjd.cli;

public enum CliCommands {
    LIST("Показать все вопросы"), ADD("Добавить вопрос"), EXIT("Выйти"), MENU("Меню"), UNRECOGNIZED("Неопознано");

    private final String title;

    CliCommands(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }
}
