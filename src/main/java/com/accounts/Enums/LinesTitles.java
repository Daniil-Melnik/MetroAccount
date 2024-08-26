package com.accounts.Enums;

public enum LinesTitles {
    LINE_1("1 (Кировско-Выборгская)"),
    LINE_2("2 (Московско-Петроградская)"),
    LINE_3("3 (Невско-Василиеостровская)"),
    LINE_4("4 (Лахтинско-Правобережная)"),
    LINE_5("5 (Фрунзенско-Приморская)");

    private final String description;

    LinesTitles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
