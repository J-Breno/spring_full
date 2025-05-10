package com.github.jbreno.gestao_vagas.modules.company.repositories;

import com.github.jbreno.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    Optional<JobEntity> findByUsernameOrEmail(String username, String email);

}
