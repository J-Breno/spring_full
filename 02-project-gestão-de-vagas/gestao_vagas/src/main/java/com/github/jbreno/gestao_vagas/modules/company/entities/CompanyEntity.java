package com.github.jbreno.gestao_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tb_company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;
    @Size(min = 10, max = 100, message = "A senha deve conter entre 10 a 100 caracteres")
    private String password;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    private String website;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
