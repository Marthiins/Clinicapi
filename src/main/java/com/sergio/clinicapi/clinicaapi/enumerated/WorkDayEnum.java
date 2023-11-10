package com.sergio.clinicapi.clinicaapi.enumerated;

public enum WorkDayEnum { // dia de Trabalho de segunda a sabado

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    private final int index;

    WorkDayEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
