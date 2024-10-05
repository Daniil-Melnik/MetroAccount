package com.accounts.Enums;

public enum CarriagesModels {
    BALTIETS1_F("«Балтиец» 81-725"),
    BALTIETS1_I1("«Балтиец» 81-726"),
    BALTIETS1_I2("«Балтиец» 81-727"),
    BALTIETS2_H("«Балтиец» 81-725.1"),
    BALTIETS2_I1("«Балтиец» 81-726.1"),
    BALTIETS2_I2("«Балтиец» 81-727.1"),
    EM501("Ем-501"),
    EM502("Емa-502"),
    NEVA1_H("«НеВа» 81-556"),
    NEVA1_I1("«НеВа» 81-557"),
    NEVA1_I2("«НеВа» 81-558"),
    NEVA2_H("«НеВа» 81-556.1"),
    NEVA2_I1("«НеВа» 81-557.1"),
    NEVA2_I2("«НеВа» 81-558.1"),
    NEVA3_H("«НеВа» 81-556.2"),
    NEVA3_I1("«НеВа» 81-557.2"),
    NEVA3_I2("«НеВа» 81-558.2"),
    NOMERNOY1_H("«Номерной» 81-717"),
    NOMERNOY1_I("«Номерной» 81-714"),
    NOMERNOY4_H("«Номерной» 81-717.5"),
    NOMERNOY4_I("«Номерной» 81-714.5"),
    NOMERNOY5_H("«Номерной» 81-717.5П"),
    NOMERNOY5_I("«Номерной» 81-714.5П"),
    NOMERNOY2_H("«Номерной» 81-540"),
    NOMERNOY2_I("«Номерной» 81-541"),
    NOMERNOY2_1_H("«Номерной» 81-540.1"),
    NOMERNOY2_1_I("«Номерной» 81-541.1"),
    NOMERNOY3_H("«Номерной» 81-540.2"),
    NOMERNOY3_I("«Номерной» 81-541.2"),
    NOMERNOY6_H("«Номерной» 81-540.5"),
    NOMERNOY6_I("«Номерной» 81-541.5"),
    NOMERNOY7_H("«Номерной» 81-540.7"),
    NOMERNOY7_I("«Номерной» 81-541.7"),
    NOMERNOY8_H("«Номерной» 81-540.9"),
    NOMERNOY8_I("«Номерной» 81-541.9"),
    YUBILEYNY1_H("«Юбилейный» 81-722"),
    YUBILEYNY1_IM("«Юбилейный» 81-724"),
    YUBILEYNY1_IT("«Юбилейный» 81-723"),
    YUBILEYNY2_H("«Юбилейный» 81-722.1"),
    YUBILEYNY2_IM("«Юбилейный» 81-724.1"),
    YUBILEYNY2_IT("«Юбилейный» 81-723.1"),
    YUBILEYNY3_H("«Юбилейный» 81-722.3"),
    YUBILEYNY3_IM("«Юбилейный» 81-724.3"),
    YUBILEYNY3_IT("«Юбилейный» 81-723.3");

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
