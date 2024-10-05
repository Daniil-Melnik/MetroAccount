package com.accounts.Enums;

public enum Factories {
    LVZ("ЛВЗ им. И. Е. Егорова"),
    VAGONMASH("Вагонмаш"),
    OERVZ("ОЭВРЗ"),
    MVM("Метровагонмаш"),
    KIROV("Кировский завод");

    private final String description;

    Factories(String description) {
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
