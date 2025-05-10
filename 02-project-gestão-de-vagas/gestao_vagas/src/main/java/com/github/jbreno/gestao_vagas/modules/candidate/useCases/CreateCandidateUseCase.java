package com.github.jbreno.gestao_vagas.modules.candidate.useCases;

import com.github.jbreno.gestao_vagas.exceptions.UserFoundException;
import com.github.jbreno.gestao_vagas.modules.candidate.entites.CandidateEntity;
import com.github.jbreno.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {
        candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
        return candidateRepository.save(candidate);
    }
}
