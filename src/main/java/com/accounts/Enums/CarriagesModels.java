package com.accounts.Enums;

public enum CarriagesModels {
    BALTIETS("81-725/726/727 «Балтиец»"),
    YUBILEYNY("81-722/723/724 «Юбилейный»"),
    EM("Ем"),
    NEVA("81-556/557/558 НеВа"),
    NOMERNOY1("81-717/714");

    private final String description;

    CarriagesModels(String description) {
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
