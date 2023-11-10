package com.sergio.clinicapi.clinicaapi.entity;

import com.sergio.clinicapi.clinicaapi.enumerated.WorkDayEnum;
import com.sergio.clinicapi.clinicaapi.util.ConvertingType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "tb_consulta")
@Getter
@Setter
public class Consulta implements Serializable { //  Serializable faz referência a uma instância de sua classe.

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE) //omitir completamente o acessador
    private String id = UUID.randomUUID().toString();

    @Column(name = "procedimento", nullable = false)
    private String procedimento;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate dataConsulta;

    @Column(name = "time_start", nullable = false)
    private LocalTime timeStart;

    @Column(name = "time_end", nullable = false)
    private LocalTime timeEnd;

    @Column(name = "week_day", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkDayEnum weekDay; //dia de trabalho e dia da semana

    @ManyToOne //Muitas consultas para um dentista
    @JoinColumn(name = "dentist_id", foreignKey = @ForeignKey(name = "fk_consulta_dentist"), nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_consulta_patient"), nullable = false)
    private Patient patient;

    @Builder
    public Consulta(@NonNull String procedimento, @NonNull LocalDate dataConsulta, @NonNull LocalTime timeStart, @NonNull LocalTime timeEnd,
                       Dentist dentist, Patient patient) {

        this.procedimento = procedimento;
        this.dataConsulta = dataConsulta;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.dentist = dentist;
        this.patient = patient;
        this.weekDay = ConvertingType.getWeekDayByLocalDate(dataConsulta);
    }
}
