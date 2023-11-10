package com.sergio.clinicapi.clinicaapi.entity;

import com.sergio.clinicapi.clinicaapi.enumerated.Gender;
import com.sergio.clinicapi.clinicaapi.enumerated.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@Table(name = "tb_secretaries")
@Getter
@Setter
@Entity
public class Secretary  extends User{ //Todos os dados do usuario a secretaria vai ter mais registration

    @Column(name = "registration", nullable = false, unique = true)
    private String registration;

    @Builder(builderMethodName = "secretaryBuilder") // @Builder criar objetos que requerem muitos parâmetros sem precisarmos de construtores e sem métodos setters em nossas classes.
    public Secretary(@NonNull String login, @NonNull String email, @NonNull String name, @NonNull String cellphone, @NonNull String password,
                     @NonNull Gender gender, @NonNull String country, @NonNull String state, @NonNull String city, @NonNull String registration) {

        super(login, email, name, cellphone, password, gender, country, state, city);
        setRole(Role.SECRETARY);
        setEnabled(true);
        this.registration = registration;
    }
}
