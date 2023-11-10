package com.sergio.clinicapi.clinicaapi.util;

import com.sergio.clinicapi.clinicaapi.entity.WorkDay;

import java.util.Comparator;

public class MyWorkDayListComparator implements Comparator<WorkDay> { //Comparador de lista de dias de trabalho
    @Override
    public int compare(WorkDay workDay1, WorkDay workDay2) {
       return workDay1.getIndex().compareTo(workDay2.getIndex());
    }


}
