package com.github.jbreno.gestao_vagas.modules.company.useCases;

import com.github.jbreno.gestao_vagas.exceptions.UserFoundException;
import com.github.jbreno.gestao_vagas.modules.company.entities.CompanyEntity;
import com.github.jbreno.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity company) {
        companyRepository.findByUsernameOrEmail(
                        company.getUsername(),
                        company.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
       return companyRepository.save(company);
    }
}
