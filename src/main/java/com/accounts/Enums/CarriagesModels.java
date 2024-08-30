package com.accounts.Enums;

public enum CarriagesModels {
    BALTIETS("«Балтиец» 81-725/726/727"),
    EM("«Ем»"),
    NEVA("«НеВа» 81-556/557/558 "),
    NOMERNOY1_H("«Номерной» 81-717"),
    NOMERNOY1_I("«Номерной» 81-714"),
    NOMERNOY4_H("«Номерной» 81-717.5"),
    NOMERNOY4_I("«Номерной» 81-714.5"),
    NOMERNOY5_H("«Номерной» 81-717.5П"),
    NOMERNOY5_I("«Номерной» 81-714.5П"),
    NOMERNOY2("«Номерной» 81-540/541"),
    NOMERNOY3("«Номерной» 81-540.2/541.2"),
    NOMERNOY6("«Номерной» 81-540.5/541.5"),
    NOMERNOY7("«Номерной» 81-540.7/541.7"),
    YUBILEYNY("«Юбилейный» 81-722/723/724 ");

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
