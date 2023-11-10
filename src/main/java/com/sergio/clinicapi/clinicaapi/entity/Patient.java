package com.sergio.clinicapi.clinicaapi.entity;

import com.sergio.clinicapi.clinicaapi.enumerated.Gender;
import com.sergio.clinicapi.clinicaapi.enumerated.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*; //import das anotação @getter e Setter e COnstrutores

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "tb_patients")
@Getter
@Setter
public class Patient extends User {

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "patient") //  mappedBy é para indicar qual é o lado inverso ou não dominante da relação
    private List<Consulta> consultas = new ArrayList<>();

    @Builder(builderMethodName = "patientBuilder")
    public Patient(@NonNull String login, @NonNull String email, @NonNull String name, @NonNull String cellphone, String password, @NonNull Gender gender,
                   @NonNull String country, @NonNull String state, @NonNull String city, @NonNull String cpf) {
        super(login, email, name, cellphone, password, gender, country, state, city);
        setRole(Role.PATIENT);
        this.cpf = cpf;
    }
}