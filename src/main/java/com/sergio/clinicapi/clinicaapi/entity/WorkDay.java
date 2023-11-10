package com.sergio.clinicapi.clinicaapi.entity;

import com.sergio.clinicapi.clinicaapi.enumerated.WorkDayEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_workdays")
@NoArgsConstructor
@Getter
@Setter
public class WorkDay implements Serializable { // Dia de Trabalho

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "work_day", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private WorkDayEnum workDay;

    @Column(name = "index", nullable = false, unique = true)
    private Integer index; //indice do dia da semana

    @OneToMany(mappedBy = "weekDay") //vai ter varias consultas no dia de trabalho
    private final List<Consulta> consultas = new ArrayList<>();

    @ManyToMany(mappedBy = "workDays") //dentista vai ter varios dias trabalhando
    private final List<Dentist> dentists = new ArrayList<>();

    public WorkDay(WorkDayEnum workDay) {
        this.workDay = workDay;
        this.index = workDay.getIndex(); //Ele vai pegar o index do dia da semana
    }
}
