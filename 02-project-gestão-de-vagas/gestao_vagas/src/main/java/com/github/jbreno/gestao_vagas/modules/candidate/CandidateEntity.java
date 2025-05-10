package com.github.jbreno.gestao_vagas.modules.candidate;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_candidate")
public class CandidateEntity {
    @Id
    private UUID id;
    private String name;
    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;
    @Size(min = 10, max = 100, message = "A senha deve conter entre 10 a 100 caracteres")
    private String password;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
