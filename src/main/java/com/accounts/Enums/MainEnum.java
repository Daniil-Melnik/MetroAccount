package com.accounts.Enums;

public enum MainEnum {

    MAIN_JSON_PATH("src/json/main_info/"),
    VAGON_TIME_JSON_PATH("src/json/time_info/"),
    HEAD_JSON_PATH("src/json/");

    private final String description;

    MainEnum(String description) {
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
