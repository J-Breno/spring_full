package com.github.jbreno.gestao_vagas.modules.candidate.controllers;

import com.github.jbreno.gestao_vagas.exceptions.UserFoundException;
import com.github.jbreno.gestao_vagas.modules.candidate.CandidateEntity;
import com.github.jbreno.gestao_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidate) {
        candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
        return candidateRepository.save(candidate);
    }
}
