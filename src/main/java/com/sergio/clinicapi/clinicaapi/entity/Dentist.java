package com.sergio.clinicapi.clinicaapi.entity;

import com.sergio.clinicapi.clinicaapi.enumerated.Gender;
import com.sergio.clinicapi.clinicaapi.enumerated.Role;
import com.sergio.clinicapi.clinicaapi.enumerated.Specialty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "tb_dentists")
@Getter
@Setter
public class Dentist extends User{

    @Column(name = "cro", length = 6, nullable = false, unique = true)
    private String cro;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialty", nullable = false)
    private Specialty specialty;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_dentists_workdays",
            joinColumns = @JoinColumn(name = "dentist_id", foreignKey = @ForeignKey(name = "fk_dentist")),
            inverseJoinColumns = @JoinColumn(name = "workday_id", foreignKey = @ForeignKey(name = "fk_workday")),
            indexes = {@Index(name = "dentists_workdays_pkey",columnList = "dentist_id, workday_id", unique = true)}) // implementando vários @Index em uma única entidade para certificar que não pode ter dois Id registrado pelo dentist no mesmo dia
    @Setter(AccessLevel.NONE)
    private final List<WorkDay> workDays = new ArrayList<>();

    @OneToMany(mappedBy = "dentist")
    private List<Consulta> consultas = new ArrayList<>();

    @Builder(builderMethodName = "dentistBuilder")
    public Dentist(@NonNull String login, @NonNull String email, @NonNull String name, @NonNull String cellphone, String password, @NonNull Gender gender,
                   @NonNull String country, @NonNull String state, @NonNull String city, @NonNull String cro, @NonNull Specialty specialty) {
        super(login, email, name, cellphone, password, gender, country, state, city);
        setRole(Role.DENTIST);
        this.cro = cro;
        this.specialty = specialty;

    }
        public void addWorkDay(WorkDay workDay) { //Adicionar dia de trabalho ao dentist
            this.workDays.add(workDay);
        }
    }

