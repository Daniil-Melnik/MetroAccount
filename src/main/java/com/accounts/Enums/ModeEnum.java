package com.accounts.Enums;

public enum ModeEnum {
    FILE_IO_MAIN_MODE(1),
    FILE_IO_VAGON_TIME_MODE(2);

    private final int description;

    ModeEnum(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }

    public int toInt() {
        return description;
    }

}
